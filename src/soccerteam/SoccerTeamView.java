package soccerteam;

import java.awt.event.ActionListener;

/**
 * The SoccerTeamView interface represents the view component
 * for a children's soccer team application.
 */
public interface SoccerTeamView {

  /**
   * Updates the current player number displayed on the view.
   *
   * @param curPlayerNum the new current player number
   */
  void updateCurPlayerNum(int curPlayerNum);

  /**
   * Sets the ActionListener for the "Add Player" button.
   *
   * @param listener the ActionListener for the button
   */
  void setAddPlayerButtonListener(ActionListener listener);

  /**
   * Sets the ActionListener for the "Create Team" button.
   *
   * @param listener the ActionListener for the button
   */
  void setCreateTeamButtonListener(ActionListener listener);

  /**
   * Resets the text fields in the view.
   */
  void resetTextField();

  /**
   * Retrieves the first name entered in the view.
   *
   * @return the first name
   */
  String getFirstName();

  /**
   * Retrieves the last name entered in the view.
   *
   * @return the last name
   */
  String getLastName();

  /**
   * Retrieves the date of birth entered in the view.
   *
   * @return the date of birth
   */
  String getDateOfBirth();

  /**
   * Retrieves the preferred position selected in the view.
   *
   * @return the preferred position
   */
  Position getPreferredPosition();

  /**
   * Retrieves the skill level entered in the view.
   *
   * @return the skill level
   */
  int getSkillLevel();

  /**
   * Displays an error message in the view.
   *
   * @param message the error message to be displayed
   */
  void showErrorMessage(String message);

  /**
   * Displays a success message in the view.
   *
   * @param message the success message to be displayed
   */
  void showSuccessMessage(String message);

  /**
   * Updates the team list displayed in the view.
   *
   * @param teamList the formatted team list string
   */
  void updateTeamList(String teamList);

  /**
   * Updates the starting lineup displayed in the view.
   *
   * @param startingLineup the formatted starting lineup string
   */
  void updateStartingLineup(String startingLineup);
}