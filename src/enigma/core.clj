(ns enigma.core)

(def r-rotor
  [\b \d \f \h \j \l \c \p \r \t \x \v \z \n \y \e \i \w \g \a \k \m \u \s \q \o])

(def c-rotor
  [\a \j \d \k \s \i \r \u \x \b \l \h \w \d \m \c \q \g \z \n \p \y \f \v \o \e])

(defn mod-alpha [alpha]
  (mod alpha 26))

(defn rotor-shift [letter]
  (char (+ 
          (int \a) 
          (mod-alpha (+ (char-to-index letter) 1)))))

(defn char-to-index [letter]
  (- (int letter) (int \a)))

(defn rotor-enc [seed input rotor]
  (rotor (mod-alpha (+ (char-to-index seed) (char-to-index input)))))

(defn int-to-char [integer]
  (char (+ (int \a) (mod-alpha integer))))

(defn r-rotor-enc [seed input]
  (int-to-char (mod-alpha (+ (- 26 (char-to-index seed)) (char-to-index (rotor-enc seed input r-rotor))))))

(defn c-rotor-enc [seed input]
  (rotor-enc seed input c-rotor)) 

(defn generate-seeds [howmany start]
  (map char (range (+ 1 (int start)) (+ howmany (+ 1 (int start))))))

(defn enigma [setup message]
  (let [r-output (map r-rotor-enc (generate-seeds (count message) (last setup)) (seq message))]
        (apply str (map c-rotor-enc 
                        (generate-seeds (count message) (get setup 1)) 
                        r-output))))
