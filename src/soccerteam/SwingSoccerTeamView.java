package soccerteam;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

/**
 * SwingSoccerTeamView is the implementation of the view interface allowing
 * the user to input player information and manage the team. It includes input components for
 * player details, action buttons for adding players and creating the team, and output
 * components for displaying team information.
 */
public class SwingSoccerTeamView extends JFrame implements SoccerTeamView {
  private final JTextField firstNameField;
  private final JTextField lastNameField;
  private final JTextField dateOfBirthField;
  private final JComboBox<Position> preferredPositionField;
  private final JSpinner skillLevelField;
  private final JButton addPlayerButton;
  private final JButton createTeamButton;
  private final JTextArea teamListTextArea;
  private final JTextArea startingLineupTextArea;
  private final JLabel curPlayerNum;

  /**
   * Constructs a new SwingSoccerTeamView, initializing and configuring the GUI components.
   * This constructor sets the window title, default close operation, layout, and adds
   * input and output panels. It also sets the initial visibility and window location.
   */
  public SwingSoccerTeamView() {

    setTitle("Soccer Team Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    // Input panel
    JPanel inputPanel = new JPanel(new GridLayout(7, 2));
    inputPanel.setPreferredSize(new Dimension(500, 300));

    inputPanel.add(new JLabel("First Name:"));
    firstNameField = new JTextField();
    inputPanel.add(firstNameField);
    inputPanel.add(new JLabel("Last Name:"));
    lastNameField = new JTextField();
    inputPanel.add(lastNameField);
    inputPanel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
    dateOfBirthField = new JTextField();
    inputPanel.add(dateOfBirthField);
    inputPanel.add(new JLabel("Preferred Position:"));
    preferredPositionField = new JComboBox<>(Position.values());
    inputPanel.add(preferredPositionField);
    inputPanel.add(new JLabel("Skill Level (1-5):"));
    skillLevelField = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
    JComponent editor = skillLevelField.getEditor();
    if (editor instanceof JSpinner.DefaultEditor) {
      JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
      textField.setHorizontalAlignment(JTextField.LEFT);
    }
    inputPanel.add(skillLevelField);

    addPlayerButton = new JButton("Add Player");
    inputPanel.add(addPlayerButton);
    createTeamButton = new JButton("Create Team");
    inputPanel.add(createTeamButton);

    inputPanel.add(new JLabel("Current Player Number:"));
    curPlayerNum = new JLabel("0");
    curPlayerNum.setHorizontalAlignment(JLabel.CENTER);
    curPlayerNum.setVerticalAlignment(JLabel.CENTER);
    inputPanel.add(curPlayerNum);

    add(inputPanel, BorderLayout.CENTER);

    // Output panel
    JPanel outputPanel = new JPanel(new GridLayout(1, 2));
    outputPanel.setPreferredSize(new Dimension(500, 400));
    outputPanel.setBorder(BorderFactory.createTitledBorder("Team Information"));

    teamListTextArea = new JTextArea();
    teamListTextArea.setEditable(false);
    JScrollPane teamListScrollPane = new JScrollPane(teamListTextArea);
    outputPanel.add(teamListScrollPane);

    startingLineupTextArea = new JTextArea();
    startingLineupTextArea.setEditable(false);
    JScrollPane startingLineupScrollPane = new JScrollPane(startingLineupTextArea);
    outputPanel.add(startingLineupScrollPane);
    add(outputPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
    setLocationRelativeTo(null);
  }

  @Override public void updateCurPlayerNum(int curPlayerNum) {
    this.curPlayerNum.setText(Integer.toString(curPlayerNum));
  }

  @Override public void setAddPlayerButtonListener(ActionListener listener) {
    addPlayerButton.addActionListener(listener);
  }

  @Override public void setCreateTeamButtonListener(ActionListener listener) {
    createTeamButton.addActionListener(listener);
  }

  @Override public void resetTextField() {
    firstNameField.setText("");
    lastNameField.setText("");
    dateOfBirthField.setText("");
  }

  @Override public String getFirstName() {
    return firstNameField.getText();
  }

  @Override public String getLastName() {
    return lastNameField.getText();
  }

  @Override public String getDateOfBirth() {
    return dateOfBirthField.getText();
  }

  @Override public Position getPreferredPosition() {
    return (Position) preferredPositionField.getSelectedItem();
  }

  @Override public int getSkillLevel() {
    return (Integer) skillLevelField.getValue();
  }

  @Override public void showErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override public void showSuccessMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
  }

  @Override public void updateTeamList(String teamList) {
    teamListTextArea.setText(teamList);
  }

  @Override public void updateStartingLineup(String startingLineup) {
    startingLineupTextArea.setText(startingLineup);
  }
}