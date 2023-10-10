package soccerteam;

/**
 * Interface for the Soccer Team Controller.
 */
public interface SoccerTeamController {

  void start();

  /**
   * Adds a player to the list of players in the model.
   * The user input from the view is used to create a new player object.
   * The player is added to the model and the view is updated accordingly.
   * If any exception occurs, such as the player not meeting age requirements,
   * an error message will be displayed in the view.
   */
  void addPlayer();

  void createTeam();
}
