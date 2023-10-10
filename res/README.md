About/Overview:
The Children's Soccer Team Management Application is a Java Swing-based program designed to help a coach manage a children's soccer team. This application follows the Model-View-Controller (MVC) architectural pattern and allows the coach to add players as candidates for the team, create a team with a starting lineup, and view the team list and starting lineup.

List of features:
This program allows the user to input information of each player and add players to the team one by one. Once the user finish inputting, this program examines the input. If the player number is valid, the program will assign jersey number and provide the list of official team and the list of starting lineup in order.
The program shows the number of currently accepted player number and automatically clear the player information once successfully added for the user to inout  the next player's information.

How To Run:
The program can either run by double-clicking the SoccerTeamAPP.jar or by using command "java -jar SoccerTeamAPP.jar" in the command line to execute.

How to Use the Program:
1. Fill in the player details, such as first name, last name, date of birth, preferred position, and skill level.
2. Click the "Add Player" button to add the player as a candidate for the team. If the player is ineligible due to age restrictions, an error message will be displayed.
3. Continue adding players until you have enough players to create a team (minimum of 10 players).
4. Click the "Create Team" button to create the team and starting lineup.
5. The "Team List" and "Starting Lineup" sections will display the list of all team players and the starting lineup, respectively, including jersey numbers.

Design/Model Changes:
The major change I made was in the model. I initialize those fields with an empty value instead of taking a list of players as parameters to fit the nature of a program with nop initial database. Therefore, some methods that were created for testing purpose are deleted. The return type of "formTeam()" and "formStartingLineup()" changed from List<Player> to void.

Assumptions:
1. Children can have the same name.
2. Children can play soccer as long as they were born(even 1 day old) and under 10 years old.
3. Names cannot contain anything beside alphabetical letters.


Limitations:
1. Once the user added a player, the user cannot delete the player from the player pool.
2. When the "create team" is clicked, all players jersey will be randomly assigned again.

Citations:
Hartman, J. (2023, March 11). Java Swing Tutorial: How to create a GUI application in Java. Guru99. Retrieved April 21, 2023, from https://www.guru99.com/java-swing-gui.html
Java program to set alignment for text in jlabel. Tutorials Point. (n.d.). Retrieved April 21, 2023, from https://www.tutorialspoint.com/java-program-to-set-alignment-for-text-in-jlabel
Java Swing Tutorial - javatpoint. www.javatpoint.com. (n.d.). Retrieved April 21, 2023, from https://www.javatpoint.com/java-swing
Java swing tutorial: Container, components and event handling. Software Testing Help. (2023, March 17). Retrieved April 21, 2023, from https://www.softwaretestinghelp.com/java/java-swing-tutorial/
Luca, Sébastien Le Callonnec, Bart Blommaerts, &amp; Nikhil Narayanan. (1959, June 1). Align text in jlabel to the right. Stack Overflow. Retrieved April 21, 2023, from https://stackoverflow.com/questions/12589494/align-text-in-jlabel-to-the-right
A simple demonstration of text alignment in JLabels : Label « Swing JFC « Java. A simple demonstration of text alignment in JLabels : Label&nbsp;"&nbsp;swing JFC&nbsp;"&nbsp;java. (n.d.). Retrieved April 21, 2023, from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
Swing in java: Creating GUI using Java Swing. Edureka. (2022, November 29). Retrieved April 21, 2023, from https://www.edureka.co/blog/java-swing/
Trail: Creating a GUI with swing. Trail: Creating a GUI With Swing (The Java™ Tutorials). (n.d.). Retrieved April 21, 2023, from https://docs.oracle.com/javase/tutorial/uiswing/ 
