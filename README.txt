HOW TO USE:
Compiling: 
1) Download the 'src' folder into it's own folder on your computer
2) Open a new Terminal/Command Prompt
3) Compile the .java files with this command: javac ./me/mango/primefinder/*.java
3) Then jar them this command: jar cvf0 PrimeFinder.jar me/mango/primefinder/*.class
Note: You may have to specify the path to the the JDK's bin.
      For me (on Windows), this is C:\Program Files\Java\jdk1.7.0_05\bin\
	  So, on Windows, with jdk 1.7.0_05, you would use these commands from the location of the .java files
	  "C:\Program Files\Java\jdk1.7.0_05\bin\javac.exe" ./me/mango/primefinder/*.java
	  "C:\Program Files\Java\jdk1.7.0_05\bin\jar.exe" cvfe0 PrimeFinder.jar me.mango.primefinder.PrimeFinder me/mango/primefinder/*.class

You may now delete the source .java and .class files if you don't want them (keep PrimeFinder.jar).

Running: 
1) Open a new Terminal/Command Prompt
2) cd to where PrimeFinder.jar is located
3) Run this command: java -jar PrimeFinder.jar