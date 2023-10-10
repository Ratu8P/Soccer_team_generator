package soccerteam;

/**
 * This is an Enum class for different position.
 */
public enum Position {
  GOALIE, DEFENDER, MIDFIELDER, FORWARD;

  @Override public String toString() {
    String name = name().toLowerCase();
    return name.substring(0, 1).toUpperCase() + name.substring(1);
  }

}
