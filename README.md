# podRacer
Pod racer game with unit tests created as an assessment.

Building the project intelij:
Go to View -> Tool Windows -> Maven Projects. (Should also be a tab on the right hand side by default)
Open the LifeCycle tree.
Right click on compile and click run podRacer [compile].
Right click on install anc click run podRacer [install].
This should generate a jar file inside the target directory that can be run.

Running the project from command prompt in windows:
Go to the jar location created when the project was built using the cd command. ie. (cd C:\Project\PodRacer)
Run the java command for the jar to run it. ie. (java -jar podRacer-1.0-SNAPSHOT.jar)
The game should show a welcome message with onscreen instructions.

General user experience.  
Running the main class should start up the process and prompt the user to enter the location of the track.txt file.
After that it will prompt the user to enter the ammount of laps for the race.
When the race is done it will print out the results to the console.
After that it will prompt the user if he wants to race again or if the user wants to quit.

The generated cars can be edited in Utility.java under generateCars.
Cars can be removed or added as needed, it just needs to be in the array and a valid Car object.

