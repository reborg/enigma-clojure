(ns enigma.core)

(def alphabet
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(def r-rotor-wiring
  ["a" "j" "d" "k" "s" "i" "r" "u" "x" "b" "l" "h" "w" "t" "m" "c" "q" "g" "z" "n" "p" "y" "f" "v" "o" "e"])

(defn ++ [letter]
  (alphabet (mod (+ 1 (.indexOf alphabet letter)) 26)))

(defn shift [letters new-start]
  (let [letter-split (split-with (fn [x] (not (= x new-start))) letters)]
    (vec 
      (apply concat 
             (list 
               (last letter-split) 
               (first letter-split))))))

(def r-rotor-map
  (apply array-map 
         (interleave 
           alphabet 
           (map #(zipmap (shift alphabet %) r-rotor-wiring) alphabet))))

(defn r-rotor [input]
  ((r-rotor-map (++ (input :offset))) (input :input)))

(defn enigma [input]
  (r-rotor input))
