(ns enigma.core)
(def rotor1
  [\E \K \M \F \L \G \D \Q \V \Z \N \T \O \W \Y \H \X \U \S \P \A \I \B \R \C \J]
  )

(def rotor2
  [\A \J \D \K \S \I \R \U \X \B \L \H \W \T \M \C \Q \G \Z \N \P \Y \F \V \O \E]
  )

(def rotor3
  [\B \D \F \H \J \L \C \P \R \T \X \V \Z \N \Y \E \I \W \G \A \K \M \U \S \Q \O]
  )

(def rotor1-state
  (atom [])
  )

(def rotor2-state
  (atom [])
  )

(def rotor3-state
  (atom [])
  )

(def alphabet
  [\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z]
  )

(defn mapfromvec
  [coll]
  (apply hash-map (vec (interleave coll (take (count coll) (range)))))
  )

(def alphamap
  (mapfromvec alphabet)
  )

(defn orientate_rotor
  [rotor state startkey]
  (reset! state (into [] (flatten (vec (reverse (split-at (get alphamap startkey) rotor))))))
  )

(defn advance_rotor
  [state]
  (reset! state (into [] (flatten (vec (reverse (split-at 1 @state))))))
  )
