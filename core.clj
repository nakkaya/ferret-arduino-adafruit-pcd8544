(native-header "Adafruit_GFX.h"
               "Adafruit_PCD8544.h")

(defmacro device [sclk din dc cs rst]
  (let [lcd-sym (gensym)
        lcd-dec (str "Adafruit_PCD8544 " lcd-sym
                     " = Adafruit_PCD8544(" sclk ", " din ", " dc ", " cs ", " rst ");")]
    `(~'do
       (~'native-declare ~lcd-dec)
       (~'cxx ~(str "__result = obj<pointer>(&" lcd-sym ");")))))

(defn begin [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->begin();")

(defn contrast [scr cont]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   number_t contrast = number::to<number_t>(cont);
   s->setContrast(contrast);")

(defn text-size [scr size]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   number_t _size = number::to<number_t>(size);
   s->setContrast(_size);")

(defn text-color-black [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->setTextColor(BLACK);")

(defn clear [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->clearDisplay();")

(defn display [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->display();")

(defn cursor [scr x y]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   number_t _x = number::to<number_t>(x);
   number_t _y = number::to<number_t>(y);
   s->setCursor(_x, _y);")

(defn println [scr msg]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);

   if (msg.is_type(runtime::type::number))
     s->println(number::to<number_t>(msg));
   else if (msg.is_type(runtime::type::string)){
     char buff [80] = {0};
     int idx = 0;
     for(auto it : runtime::range(msg)){
      buff[idx++] = number::to<char>(it);
     }
     s->println(buff);
   }")

(defn print [scr msg]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);

   if (msg.is_type(runtime::type::number)){
     if (runtime::abs(number::to<number_t>(msg) - number::to<real_t>(msg)) < FERRET_REAL_EPSILON)
       s->print(number::to<number_t>(msg));
     else
       s->print(number::to<real_t>(msg));
   }else if (msg.is_type(runtime::type::string)){
     char buff [80] = {0};
     int idx = 0;
     for(auto it : runtime::range(msg)){
      buff[idx++] = number::to<char>(it);
     }
     s->print(buff);
   }")

(defn width [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   __result = obj<number>(s->width());")

(defn draw-line-black [scr x1 y1 x2 y2]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   number_t _x1 = number::to<real_t>(x1);
   number_t _x2 = number::to<real_t>(x2);
   number_t _y1 = number::to<real_t>(y1);
   number_t _y2 = number::to<real_t>(y2);
   s->drawLine(_x1, _y1,_x2,_y2,BLACK);")
