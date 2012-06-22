(ns enigma.core)

(defn r-rotor [input]
  (({ "e" {"k" "y"}
    "f" {"l" "z"} } (:input input)) (:offset input)))

(defn enigma [input]
  (r-rotor input))
