import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;

/**
 * This is a test class for all functions in Player class.
 */
public class PlayerTest {

  private Player p1;
  private Player p2;
  /**
   * Setup Player objects for testing.
   * @throws IllegalArgumentException when the player is older than 10, or has invalid skill level.
   */
  @Before public void setUp() throws IllegalArgumentException {
    p1 = new Player("First", "Player", "2013-05-01", Position.GOALIE, 3);
    p2 = new Player("Second", "Player", "2023-04-01", Position.DEFENDER, 1);
  }

  /**
   * the constructor needs to throw IllegalArgumentException when skill level is less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void lessThanOneSkillLevel() {
    new Player("a", "b", "2020-01-11", Position.FORWARD, 0);
  }

  /**
   * the constructor needs to throw IllegalArgumentException when skill level is greater than 5.
   */
  @Test(expected = IllegalArgumentException.class)
  public void greaterThanFiveSkillLevel() {
    new Player("a", "b", "2020-01-11", Position.FORWARD, 6);
  }

  /**
   * the constructor needs to throw IllegalArgumentException when the birthday format is wrong.
   */
  @Test(expected = IllegalArgumentException.class)
  public void invalidDateFormat() {
    new Player("a", "b", "20200111", Position.FORWARD, 3);
  }

  /**
   * the constructor needs to throw IllegalArgumentException when the player is older than 10.
   */
  @Test(expected = IllegalArgumentException.class)
  public void isOlderThanTen() {
    new Player("a", "b", "2012-04-01", Position.FORWARD, 3);
  }

  /**
   * the constructor needs to throw IllegalArgumentException when the player has not born yet.
   */
  @Test(expected = IllegalArgumentException.class)
  public void notBornYet() {
    new Player("a", "b", "2023-12-01", Position.FORWARD, 3);
  }

  /**
   * Test getFirstName() work as expected.
   */
  @Test public void getFirstName() {
    assertEquals("First", p1.getFirstName());
    assertEquals("Second", p2.getFirstName());
  }

  /**
   * Test getLastName() work as expected.
   */
  @Test public void getLastName() {
    assertEquals("Player", p1.getLastName());
    assertEquals("Player", p2.getLastName());
  }

  /**
   * Test getPreferredPosition() work as expected.
   */
  @Test public void getPreferredPosition() {
    assertEquals("Goalie", p1.getPreferredPosition().toString());
    assertEquals("Defender", p2.getPreferredPosition().toString());
    assertEquals(Position.GOALIE, p1.getPreferredPosition());
    assertEquals(Position.DEFENDER, p2.getPreferredPosition());
  }

  /**
   * Test getSkillLevel() work as expected.
   */
  @Test public void getSkillLevel() {
    assertEquals(3, p1.getSkillLevel());
    assertEquals(1, p2.getSkillLevel());
  }
}