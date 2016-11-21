(native-header "Adafruit_GFX.h"
               "Adafruit_PCD8544.h")

(defmacro define [sclk din dc cs rst]
  (let [lcd-sym (gensym)
        lcd-dec (str "Adafruit_PCD8544 " lcd-sym
                     " = Adafruit_PCD8544(" sclk ", " din ", " dc ", " cs ", " rst ");")]
    `(~'do
       (~'native-declare ~lcd-dec)
       (~'cxx ~(str "__result = obj<Pointer>(&" lcd-sym ");")))))

(defn begin [scr]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   s->begin();")

(defn contrast [scr cont]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   number_t contrast = cont.to<number_t>();
   s->setContrast(contrast);")

(defn text-size [scr size]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   number_t _size = size.to<number_t>();
   s->setContrast(_size);")

(defn text-color-black [scr]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   s->setTextColor(BLACK);")

(defn clear [scr]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   s->clearDisplay();")

(defn display [scr]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   s->display();")

(defn cursor [scr x y]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   number_t _x = x.to<number_t>();
   number_t _y = y.to<number_t>();
   s->setCursor(_x, _y);")

(defn println [scr msg]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();

   if (msg.is_type(runtime::type::Number))
     s->println(msg.to<number_t>());
   else if (msg.is_type(runtime::type::String)){
     char buff [80] = {0};
     int idx = 0;
     FERRET_ITERATE(msg,it){
      buff[idx++] = runtime::first(it).to<char>();
     }
     s->println(buff);
   }")

(defn print [scr msg]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();

   if (msg.is_type(runtime::type::Number))
     s->print(msg.to<float>());
   else if (msg.is_type(runtime::type::String)){
     char buff [80] = {0};
     int idx = 0;
     FERRET_ITERATE(msg,it){
      buff[idx++] = runtime::first(it).to<char>();
     }
     s->print(buff);
   }")

(defn width [scr]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   __result = obj<Number>(s->width());")

(defn draw-line-black [scr x1 y1 x2 y2]
  "Adafruit_PCD8544 *s = scr.cast<Pointer>()->pointer<Adafruit_PCD8544>();
   number_t _x1 = x1.to<number_t>();
   number_t _x2 = x2.to<number_t>();
   number_t _y1 = y1.to<number_t>();
   number_t _y2 = y2.to<number_t>();
   s->drawLine(_x1, _y1,_x2,_y2,BLACK);")
