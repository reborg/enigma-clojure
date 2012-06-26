(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "a single rotor non shifting enigma machine"
       (fact "it translates E to Y given the K offset"
             (enigma {:offset "k" :input "e"}) => "y"))

(facts "first rotor wiring"
       (fact "it translates an input letter given the no-shift offset 'A'"
             (r-rotor {:offset "a" :input "a"}) => "a"
             (r-rotor {:offset "a" :input "b"}) => "j"
             (r-rotor {:offset "a" :input "c"}) => "d")
       (fact "it translates an input letter given the 'K' offset"
             (r-rotor {:offset "k" :input "a"}) => "q"
             (r-rotor {:offset "k" :input "b"}) => "g"
             (r-rotor {:offset "k" :input "c"}) => "z"))

(facts "shifting sequences of letters"
       (fact "split and swap the sequence based on the given letter"
             (shift ["a" "b" "c"] "b") => ["b" "c" "a"])
       (fact "no shift required if letter is already first"
             (shift ["a" "b" "c"] "a") => ["a" "b" "c"]))
