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

(defn contrast [scr ^number_t c]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->setContrast(c);")

(defn text-size [scr ^number_t size]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->setTextSize(size);")

(defn clear [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->clearDisplay();")

(defn display [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->display();")

(defn cursor [scr ^number_t x ^number_t y]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->setCursor(x, y);")

(defn print [scr msg]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);

   if (msg.is_type(type_id<number>))
     if (runtime::abs(number::to<number_t>(msg) - number::to<real_t>(msg)) < FERRET_REAL_EPSILON)
       s->print(number::to<number_t>(msg));
     else
       s->print(number::to<real_t>(msg), real_precision);
   else if (msg.is_type(type_id<string>)){
     for_each(it, msg){
      s->print(number::to<char>(it));
     }
   }")

(defn println [scr msg]
  (print scr msg)
  (print scr "\n"))

(defn width [scr]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   __result = obj<number>(s->width());")

(defn draw-line [scr ^number_t x1 ^number_t y1 ^number_t x2 ^number_t y2]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->drawLine(x1, y1, x2, y2, BLACK);")

(defn fill-rect [scr ^number_t x ^number_t y ^number_t w ^number_t h]
  "Adafruit_PCD8544 *s = pointer::to_pointer<Adafruit_PCD8544>(scr);
   s->fillRect(x, y, w, h, BLACK);")
