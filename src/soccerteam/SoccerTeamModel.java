package soccerteam;

/**
 * This interface represents the operations offered by the children soccer team model.
 * One object of the model represents one children soccer team.
 */
public interface SoccerTeamModel {

  /**
   * Assigns a unique jersey number to each player
   * in the given team,
   * using a randomized list of numbers from 1 to 20.
   *
   */
  void assignJersey();

  /**
   * Forms the team from the list of players, ensuring
   * the team meets the minimum and maximum size requirements.
   *
   */
  void formTeam();

  /**
   * Forms the starting lineup for the team based on players' preferred positions and skill levels.
   *
   */
  void formStartingLineup();



  /**
   * Generates an official representation of the team, including players' names and jersey numbers.
   *
   * @return a string representation of the official team
   */
  String officialTeamString();


  /**
   * Generates a string representation of the starting lineup,
   * including players' names and jersey numbers.
   *
   * @return a string representation of the starting lineup
   */
  String startingLineupString();


  /**
   * Adds a new player to the list of players, validating and handling IllegalArgumentException.
   *
   * @param firstName the first name of the player
   * @param lastName the last name of the player
   * @param dateOfBirth the date of birth of the player
   * @param preferred the preferred position of the player
   * @param skillLevel the skill level of the player
   */
  void addPlayer(String firstName, String lastName, String dateOfBirth, Position preferred,
      int skillLevel);
}
