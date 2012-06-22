(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "a single rotor non shifting enigma machine"
       (fact "it translates E to Y given the K offset"
             (enigma {:offset "a" :input "a"}) => "a"))

(facts "rotor wiring"
       (fact "it translates an input letter given the offset"
             (r-rotor {:offset "a" :input "a"}) => "a"))

(facts "shifting sequences of letters"
       (fact "no shift required if letter is already first"
             (shift ["a" "b" "c"] "a") => ["a" "b" "c"]))
