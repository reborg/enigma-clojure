(ns enigma.core)

(defn index-of [letter-in-the-alphabet])

(defn rotor [cipher start-pos input] 
  ((vec (map #(str %) (seq cipher))) (+ (index-of input) (index-of start-pos))))
