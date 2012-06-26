(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "a single rotor enigma machine with pre-shifting"
       (fact "translates e to n given the k offset"
             (enigma {:offset "k" :input "e"}) => "n"))

(facts "first rotor wiring"
       (fact "it translates an input letter given the no-shift offset 'a'"
             (r-rotor {:offset "a" :input "a"}) => "e"
             (r-rotor {:offset "a" :input "b"}) => "a"
             (r-rotor {:offset "a" :input "c"}) => "j")
       (fact "it translates an input letter given the 'k' offset"
             (r-rotor {:offset "k" :input "a"}) => "c"
             (r-rotor {:offset "k" :input "b"}) => "q"
             (r-rotor {:offset "k" :input "c"}) => "g"))

(facts "shifting sequences of letters"
       (fact "split and swap the sequence based on the given letter"
             (shift ["a" "b" "c"] "b") => ["b" "c" "a"])
       (fact "no shift required if letter is already first"
             (shift ["a" "b" "c"] "a") => ["a" "b" "c"]))

(facts "increment operator for the alphabet"
       (fact "it returns the next letter"
             (++ "k") => "l")
       (fact "it rotates to the first when last letter"
             (++ "z") => "a"))
