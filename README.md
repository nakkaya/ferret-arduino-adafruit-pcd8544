ferret-arduino-adafruit-pcd8544
===============

Wrapper for the Adafruit Arduino driver for PC8544, most commonly found in Nokia 5110.

#### Dependencies

 - Adafruit-PCD8544-Nokia-5110-LCD-library - `https://github.com/adafruit/Adafruit-PCD8544-Nokia-5110-LCD-library`
 - Adafruit-GFX-Library - `https://github.com/adafruit/Adafruit-GFX-Library`

Both available via Arduino library manager. 

#### Usage

    (require '[ferret-arduino-adafruit-pcd8544.core :as lcd])

    ;; Software SPI (slower updates, more flexible pin options):
    ;; pin 7 - Serial clock out (SCLK)
    ;; pin 6 - Serial data out (DIN)
    ;; pin 5 - Data/Command select (D/C)
    ;; pin 4 - LCD chip select (CS)
    ;; pin 3 - LCD reset (RST)
    (def screen (lcd/device 7 6 5 4 3))

    (lcd/clear   screen)
    (lcd/cursor  screen 0 0)
    (lcd/println screen "Hello World.")

    (forever (sleep 100))