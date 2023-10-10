package soccerteam;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

/**
 * This is the Player class.
 * One object of the model represents one player in the soccer team.
 */
public class Player {
  private final String firstName;
  private final String lastName;
  private final Position preferred;
  private final int skillLevel;

  /**
   * Constructs a Player instance, validating input parameters and handling exceptions.
   *
   * @param firstName the first name of the player
   * @param lastName the last name of the player
   * @param birthday the date of birth of the player
   * @param preferred the preferred position of the player
   * @param skillLevel the skill level of the player
   * @throws IllegalArgumentException if any input parameters are invalid
   */
  public Player(String firstName, String lastName, String birthday,
      Position preferred, int skillLevel) throws IllegalArgumentException {

    LocalDate dob;

    if (firstName.isEmpty() || lastName.isEmpty()) {
      throw new IllegalArgumentException("Names cannot be empty.");
    }

    if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("Name can only contain A-Z");
    }

    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level should be between 1 and 5.");
    }

    // get how to calculate age from https://www.javatpoint.com/java-calculate-age
    LocalDate currentDate = LocalDate.now();
    try {
      dob = LocalDate.parse(birthday);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Please enter date of birth in YYYY-MM-DD");
    }
    if (dob.isAfter(currentDate)) {
      throw new IllegalArgumentException("Date of birth cannot be later than the current date.");
    }
    if (Period.between(dob, currentDate).getYears() > 10) {
      throw new IllegalArgumentException("Player needs to be under 10 years old.");
    }

    this.firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    this.lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
    this.preferred = preferred;
    this.skillLevel = skillLevel;
  }

  /**
   * Returns the player's first name, with the first letter capitalized
   * and the remaining letters in lowercase.
   *
   * @return the player's formatted first name
   */
  public String getFirstName() {
    String name = firstName.toLowerCase();
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

  /**
   * Returns the player's last name, with the first letter
   * capitalized and the remaining letters in lowercase.
   *
   * @return the player's formatted last name
   */
  public String getLastName() {
    String name = lastName.toLowerCase();
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

  /**
   * Returns the player's preferred position on the field.
   *
   * @return the player's preferred position
   */
  public soccerteam.Position getPreferredPosition() {
    return preferred;
  }

  /**
   * Returns the player's skill level, represented as an integer between 1 and 5.
   *
   * @return the player's skill level
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  @Override public String toString() {
    return this.firstName + " " + this.lastName + " ";
  }

}

