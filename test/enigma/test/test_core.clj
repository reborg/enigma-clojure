(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "about a single rotor enigma machine without rotor shifting"
       (fact "it gives me back a Y if I say E in start position L"
             (enigma "L" "E") => "Y")
       (fact "it gives me back a P if I say Q in start position L"
             (enigma "L" "Q") => "P"))
             
