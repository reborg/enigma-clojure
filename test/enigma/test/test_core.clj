(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "a single rotor non shifting enigma machine"
       (fact "it translates E to Y given the K offset"
             (enigma {:offset "k" :input "e"}) => "y"))

(facts "rotor wiring"
       (fact "no shifting must be explicit in input"
             (r-rotor {:offset "k" :input "e" :shift false}) => "y"))
