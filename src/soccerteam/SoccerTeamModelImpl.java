package soccerteam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * This is the implementation of SoccerTeamModel includes
 * the operations offered by the children soccer team model.
 */
public class SoccerTeamModelImpl implements SoccerTeamModel {

  // maximum and minimum team member number
  static final int MAX_TEAM = 20;
  static final int MIN_TEAM = 10;

  //
  private List<Player> players;
  private List<Player> team;
  private TreeMap<Position, List<Player>> startingLineup;
  private HashMap<Player, Integer> jerseyNumber;

  /**
   * Constructs a new SoccerTeamModelImpl with the given list of players and initializes the team,
   * starting lineup, and jersey numbers.
   *
   * @throws IllegalArgumentException if the list of players information is invalid
   */
  public SoccerTeamModelImpl() throws IllegalArgumentException {
    this.players = new ArrayList<>();
    this.team = new ArrayList<>();
    this.startingLineup = new TreeMap<>();
    this.jerseyNumber = new HashMap<>();
  }

  /**
   * Sorts the given list of players by their last names in ascending order.
   *
   * @param players the list of players to be sorted
   */
  private void sortByLastName(List<Player> players) {
    players.sort(Comparator.comparing(Player::getLastName));
  }

  /**
   * Sorts the given list of players by their skill level in descending order.
   *
   * @param players the list of players to be sorted
   */
  private void sortBySkillLevel(List<Player> players) {
    players.sort(Comparator.comparingInt(Player::getSkillLevel).reversed());
  }

  public int getPlayerSize() {
    return this.players.size();
  }

  @Override
  public void addPlayer(String firstName, String lastName, String dateOfBirth,
                        Position preferred, int skillLevel) throws IllegalArgumentException {
    Player freshFish = new Player(firstName, lastName, dateOfBirth, preferred, skillLevel);
    this.players.add(freshFish);
  }

  @Override public void assignJersey() {
    HashMap<Player, Integer> jerseyNumber = new HashMap<>();
    List<Integer> randomList = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      randomList.add(i);
    }
    Collections.shuffle(randomList);

    for (int i = 0; i < team.size(); i++) {
      jerseyNumber.put(team.get(i), randomList.get(i));
    }

    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Validates the given list of players by ensuring the list is not
   * null, contains at least the minimum required number of players,
   * and sorts the players by skill level. Adds the top players to the
   * team until the maximum team size is reached.
   *
   * @param players the list of players to be validated
   * @return a validated list of players for the team
   * @throws IllegalArgumentException if the players size is less than the minimum required number
   */
  private List<Player> validatePlayers(List<Player> players) throws IllegalArgumentException {
    List<Player> team = new ArrayList<>();

    if (players == null) {
      throw new IllegalArgumentException("Add more player to the team.");
    }

    if (players.size() < MIN_TEAM) {
      throw new IllegalArgumentException("Add more player to the team.");
    }

    sortBySkillLevel(players);

    for (int i = 0; i < MAX_TEAM; i++) {
      try {
        team.add(players.get(i));
      } catch (IndexOutOfBoundsException e) {
        break;
      }
    }
    return team;
  }

  @Override public void formTeam() {
    List<Player> team = new ArrayList<>(validatePlayers(players));
    sortByLastName(team);
    this.team = team;
  }

  @Override public void formStartingLineup() {
    TreeMap<Position, List<Player>> startingLineup = new TreeMap<>();
    List<Player> losers = new ArrayList<>();
    List<Player> pool = team;
    sortBySkillLevel(pool);

    // create empty value list for each Position key
    for (Position position : Position.values()) {
      startingLineup.put(position, new ArrayList<>());
    }

    // sorted pool, just pick the top 7
    for (int i = 0; i < 7; i++) {
      Player player = pool.get(i);

      // fill the starting lineup by preferred position first
      if (startingLineup.get(Position.GOALIE).size() < 1
          && player.getPreferredPosition() == Position.GOALIE) {
        startingLineup.get(Position.GOALIE).add(player);
      } else if (startingLineup.get(Position.DEFENDER).size() < 2
          && player.getPreferredPosition() == Position.DEFENDER) {
        startingLineup.get(Position.DEFENDER).add(player);
      } else if (startingLineup.get(Position.MIDFIELDER).size() < 3
          && player.getPreferredPosition() == Position.MIDFIELDER) {
        startingLineup.get(Position.MIDFIELDER).add(player);
      } else if (startingLineup.get(Position.FORWARD).size() < 1
          && player.getPreferredPosition() == Position.FORWARD) {
        startingLineup.get(Position.FORWARD).add(player);
      } else {
        losers.add(player);
      }
    }

    // assign losers randomly
    for (Player loser : losers) {
      if (startingLineup.get(Position.GOALIE).size() < 1) {
        startingLineup.get(Position.GOALIE).add(loser);
      } else if (startingLineup.get(Position.DEFENDER).size() < 2) {
        startingLineup.get(Position.DEFENDER).add(loser);
      } else if (startingLineup.get(Position.MIDFIELDER).size() < 3) {
        startingLineup.get(Position.MIDFIELDER).add(loser);
      } else if (startingLineup.get(Position.FORWARD).size() < 1) {
        startingLineup.get(Position.FORWARD).add(loser);
      }
    }

    // sort every value by last name
    for (Position position : Position.values()) {
      sortByLastName(startingLineup.get(position));
    }
    this.startingLineup = startingLineup;
  }

  @Override public String startingLineupString() {
    String player;
    StringBuilder startingLineup = new StringBuilder();
    startingLineup.append("List of the starting lineup:\n");
    Set<Position> keys = this.startingLineup.keySet();
    for (Position position : keys) {
      startingLineup.append("    ").append(position.toString()).append(":\n");
      for (Player p : this.startingLineup.get(position)) {
        player = p.toString() + ": " + this.jerseyNumber.get(p) + "\n";
        startingLineup.append("  ").append(player);
      }
    }
    return String.valueOf(startingLineup);
  }

  @Override public String officialTeamString() {
    String player;
    StringBuilder officialTeam = new StringBuilder();
    officialTeam.append("List of all the players in the team:\n");
    sortByLastName(team);
    for (Player p : team) {
      player = p.toString() + this.jerseyNumber.get(p) + "\n";
      officialTeam.append(player);
    }
    return String.valueOf(officialTeam);
  }

}

