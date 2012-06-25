(ns enigma.core)

(def alphpabet
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(def r-rotor-wiring
  ["a" "e" "o" "v" "f" "y" "p" "n" "z" "g" "q" "c" "m" "t" "w" "h" "l" "b" "x" "u" "r" "i" "s" "k" "d" "j"])

(defn shift [letters new-start]
  (let [letter-split (split-with (fn [x] (not (= x new-start))) letters)]
    (vec (apply concat (list (last letter-split) (first letter-split))))))

(def r-rotor-map
  {"a" (zipmap alphpabet r-rotor-wiring)
   "b" (zipmap alphpabet (shift r-rotor-wiring "j"))})

(defn r-rotor [input]
  ((r-rotor-map (input :input)) (input :offset)))

(defn enigma [input]
  (r-rotor input))
