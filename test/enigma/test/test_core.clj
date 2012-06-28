(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "cipher based rotor" 
       (fact "the left output is E for a right input of E in start position L"
             (rotor "bdfhjlcprtxvznyeiwgakmusqo" "L" "E") => "E")
       (fact "the left output is A for a right input of V in start position L"
             (rotor "bdfhjlcprtxvznyeiwgakmusqo" "L" "A") => "V")
       ;;(fact "the left output is B for a right input of Z in start position L"
       ;;      (rotor "bdfhjlcprtxvznyeiwgakmusqo" "L" "Z") => "B")
       )
             
 
