# Enigma Clojure

Enigma clojure is the starting point project for the dojo of the BBC clojure-ug. As such master will always be an empty starting implementation and different solutions are tracked as branches.

Enigma clojure implementes the paper enigma version that can be found at http://mckoss.com/Crypto/Enigma.htm

## How to bootstrap the project

#### command line (vimclojure, emacs/slime)
* install leningen https://github.com/technomancy/leiningen/
* type: lein midje to see the first failure

#### IntelliJ Idea
* Install "La Clojure" plugin
* Install the Leningen plugin
* Goto open project and point to the enigma-clojure project project.clj file
* The project should open fine in IntelliJ, you should see libraries from lib, lib/dev as dependencies
* Right click on test\_core.clj and run it, it should give a failed test
* If you get a "missing clojure classes" try to manually add each and every single file from the lib directory

#### Eclipse

* Install the counterclockwise plugin via external tools using the [update site](http://ccw.cgrand.net/updatesite)
* Add lein-eclipse "1.0.0" to your dependencies in your project.clj file
* Add the plugin manually with: lein plugin install lein-eclipse "1.0.0". This step is included because just adding the dependency doesn’t always work.
* Run the command "lein eclipse" in project folder to generate eclipse .project and .classpath files. It should say "created .project and .classpath".
* Restart Eclipse. Go to File - Import - General - Existing Projects in Workspace and select the project folder. 
* Unfortunately it doesn't seem to add the dev-dependencies to the project classpath. Open the project properties goto java build path - libraries and add external jar. Select all the lib/dev jars at once. 
* You should be able to select the clojure project, debug and run it.

## Paper enigma machine usage example

#### Setup
1. Select left/center/right rotors.
2. Position initial wheel positions by sliding the indicated window letter up to the first row.

#### Operation
Start at the input column at right, then work left to reflector, and then back to the right to the output column.

1. If the up arrow appears in the window row, shift that rotor and the rotor to the left up one row (the Right Rotor is always shifted up one row before each letter is encoded/decoded).
2. Select letter to encode/decode in the Input column.
3. Read adjacent letter, X , in right hand column of the Right Rotor; select the letter X in the left hand column of the Rotor.
4. Repeat for Center Rotor.
5. Repeat for Left Rotor.j
6. Read the adjacent letter, R , in the Reflector; select the other letterR intheReflector.
7. Read adjacent letter, Y , in left hand column of the Left Rotor; selecttheletterY intherighthandcolumnoftheRotor.
8. Repeat for Center Rotor.
9. Repeat for Right Rotor.
10. Write down the adjacent letter, Z , in the output column. Repeat for each letter of the message.

#### Example
Initial setting: I-II-III: MCK, Letter E encodes to Q. Sample Message: QMJIDO MZWZJFJR

## License

Copyright (C) 2012 reborg@reborg.net

Distributed under the Eclipse Public License, the same as Clojure.
