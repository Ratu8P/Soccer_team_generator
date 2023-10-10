package soccerteam;

/**
 * The SoccerTeamApp class is the entry point for the soccer team management application.
 * This class is responsible for initializing the model, view, and controller components
 * of the application and starting the graphical user interface.
 */
public class SoccerTeamApp {

  /**
   * The main method is the entry point of the application.
   * It initializes the model, view, and controller objects, connects them,
   * and starts the graphical user interface.
   *
   * @param args command line arguments, not used in this application
   */
  public static void main(String[] args) {
    SoccerTeamModelImpl soccerTeamModel = new SoccerTeamModelImpl();
    SoccerTeamView soccerTeamView = new SwingSoccerTeamView();
    SoccerTeamController soccerTeamController =
            new SoccerTeamControllerImpl(soccerTeamModel, soccerTeamView);
    soccerTeamController.start();
  }
}