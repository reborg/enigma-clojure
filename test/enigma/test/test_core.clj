(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "cipher based rotor" 
       (fact "the left output is E for a right input of E in start position L"
             (rotor "bdfhjlcprtxvznyeiwgakmusqo" "l" "e") => "e")
       (fact "the left output is V for a right input of A in start position L"
             (rotor "bdfhjlcprtxvznyeiwgakmusqo" "l" "a") => "v")
       (fact "the left output is X for a right input of Z in start position L"
             (rotor "bdfhjlcprtxvznyeiwgakmusqo" "l" "z") => "x")
       (against-background (index-of "z") => 25, (index-of "a") => 0, (index-of "e") => 4, (index-of "l") => 11))

