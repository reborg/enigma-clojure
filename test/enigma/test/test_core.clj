(ns enigma.test.test-core
  (:use enigma.core
        clojure.test
        midje.sweet))

(facts "enigma machine"
       (fact "e encrypts to q"
             (enigma "mck" "e") => "y")
       (fact "it ecrypts a string"
             (enigma "mck" "sc") => "om"))

(facts "shifting the rotor ahead"
       (fact "it shifts to the next letter"
             (rotor-shift \a) => \b)
       (fact "it restarts if Z is reached"
             (rotor-shift \z) => \a))

(facts "about rotor setup"
       (fact "when I set a rotor to a letter then the current index is the letter"
             (r-rotor-enc \l \e) => \t
             (r-rotor-enc \k \e) => \o)
       (fact "the rotor starts from the beginning if the shift is over Z"
             (r-rotor-enc \x \d) => \e))

(facts "generating the list of seeds for the rotor"
       (fact "it gives me the next seed in a list"
             (generate-seeds 1 \a) => '(\b)
             (generate-seeds 4 \e) => '(\f \g \h \i)))

(facts "transoforming integers to chars"
       (fact "number 27 is b"
             (int-to-char 27) => \b))
