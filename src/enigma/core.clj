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
   "b" (zipmap alphpabet (shift r-rotor-wiring "j"))
   "c" (zipmap alphpabet (shift r-rotor-wiring "d"))
   "d" (zipmap alphpabet (shift r-rotor-wiring "k"))
   "e" (zipmap alphpabet (shift r-rotor-wiring "s"))
   "f" (zipmap alphpabet (shift r-rotor-wiring "i"))
   "g" (zipmap alphpabet (shift r-rotor-wiring "r"))
   "h" (zipmap alphpabet (shift r-rotor-wiring "u"))
   "i" (zipmap alphpabet (shift r-rotor-wiring "x"))
   "j" (zipmap alphpabet (shift r-rotor-wiring "b"))
   "k" (zipmap alphpabet (shift r-rotor-wiring "l"))
   "l" (zipmap alphpabet (shift r-rotor-wiring "h"))
   "m" (zipmap alphpabet (shift r-rotor-wiring "w"))
   "n" (zipmap alphpabet (shift r-rotor-wiring "t"))
   "o" (zipmap alphpabet (shift r-rotor-wiring "m"))
   "p" (zipmap alphpabet (shift r-rotor-wiring "c"))
   "q" (zipmap alphpabet (shift r-rotor-wiring "q"))
   "r" (zipmap alphpabet (shift r-rotor-wiring "g"))
   "s" (zipmap alphpabet (shift r-rotor-wiring "z"))
   "t" (zipmap alphpabet (shift r-rotor-wiring "n"))
   "u" (zipmap alphpabet (shift r-rotor-wiring "p"))
   "v" (zipmap alphpabet (shift r-rotor-wiring "y"))
   "w" (zipmap alphpabet (shift r-rotor-wiring "f"))
   "x" (zipmap alphpabet (shift r-rotor-wiring "v"))
   "y" (zipmap alphpabet (shift r-rotor-wiring "o"))
   "z" (zipmap alphpabet (shift r-rotor-wiring "e"))})

(defn r-rotor [input]
  ((r-rotor-map (input :input)) (input :offset)))

(defn enigma [input]
  (r-rotor input))
