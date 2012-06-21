(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "enigma machine"
       (fact "implementing the enigma machine in software is fun! (please fix me)"
             (str "is boring") => falsey))
