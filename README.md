# Soccer_team_generator
This Java program is an implementation of a soccer team management system. It is designed to manage a children's soccer team, perform various operations related to player management, and generate information about the team's lineup and roster. Here's a summary of the key components and functionality of this program:

Data Structures: The program utilizes several data structures to manage player and team information, including List<Player> for storing players, List<Player> for the team roster, TreeMap<Position, List<Player>> for the starting lineup organized by player positions, and HashMap<Player, Integer> to assign jersey numbers to players.

Player Class: There is a Player class that represents individual soccer players. Each player has attributes such as first name, last name, date of birth, preferred position, and skill level.

Operations:

- addPlayer: Allows the addition of new players to the list of players.
- assignJersey: Randomly assigns jersey numbers to players in the team.
- formTeam: Forms a team from the list of players by selecting the top players based on their skill levels and sorts them by last names.
- formStartingLineup: Forms a starting lineup for the team by selecting players based on their preferred positions and skill levels.
- startingLineupString: Generates a formatted string representation of the starting lineup, including player names and jersey numbers.
- officialTeamString: Generates a formatted string representation of the official team roster, including player names and jersey numbers.
  
- Validation: The program validates the list of players to ensure it is not null, contains a minimum required number of players, and sorts players by skill level when forming the team.
- Sorting: Players are sorted by last name and skill level using custom sorting methods.
- Constants: It defines constants for the maximum and minimum team sizes (MAX_TEAM and MIN_TEAM).
- Error Handling: The program throws IllegalArgumentException in case of invalid inputs or insufficient players.
- Random Assignment: Jersey numbers are assigned randomly to the players using a shuffled list of numbers.
