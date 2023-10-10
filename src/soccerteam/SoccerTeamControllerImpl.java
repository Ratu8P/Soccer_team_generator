package soccerteam;

/**
 * The SoccerTeamControllerImpl class implements the SoccerTeamController interface,
 * providing the logic for user interactions in the soccer team management application.
 * It acts as an intermediary between the SoccerTeamModel and the SoccerTeamView,
 * receiving user input from the view and updating the model accordingly.
 */
public class SoccerTeamControllerImpl implements SoccerTeamController {
  private final SoccerTeamModelImpl model;
  private final SoccerTeamView view;

  /**
   * Constructs a new SoccerTeamControllerImpl object with the specified model and view.
   * Initializes the controller by setting the model and view, and sets up the event listeners
   * for user interactions in the view.
   *
   * @param model the SoccerTeamModelImpl
   * @param view  the SoccerTeamView
   */
  public SoccerTeamControllerImpl(SoccerTeamModelImpl model, SoccerTeamView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void start() {
    this.view.setAddPlayerButtonListener(e -> addPlayer());
    this.view.setCreateTeamButtonListener(e -> createTeam());
  }

  @Override
  public void addPlayer() {
    String firstName = view.getFirstName();
    String lastName = view.getLastName();
    String dateOfBirth = view.getDateOfBirth();
    Position preferredPosition = view.getPreferredPosition();
    int skillLevel = view.getSkillLevel();

    try {
      model.addPlayer(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      view.showSuccessMessage("Player added successfully!");
      view.resetTextField();
      view.updateCurPlayerNum(model.getPlayerSize());
    } catch (IllegalArgumentException e) {
      view.showErrorMessage(e.getMessage());
    }
  }

  @Override
  public void createTeam() {
    try {
      model.formTeam();
      model.assignJersey();
      model.formStartingLineup();
      view.showSuccessMessage("Team created successfully!");
      view.updateTeamList(model.officialTeamString());
      view.updateStartingLineup(model.startingLineupString());
    } catch (IllegalArgumentException e) {
      view.showErrorMessage(e.getMessage());
    }
  }
}