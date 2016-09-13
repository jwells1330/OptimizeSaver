package edu.elon.contact;

import java.awt.*;
import javax.swing.*;

public class ContactUI {

  private JFrame frame;
  private JPanel labelPanel;
  private JPanel textBoxPanel;
  private JPanel buttonsPanel;
  private JButton nextButton;
  private JButton previousButton;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenu edit;
  

  public ContactUI() {
  }

  public void createUI() {

    createFrame();
    createLabels();
    createTextBoxes();
    createButtons();
    createMenu();

  }

  public void createFrame() {
    frame = new JFrame("Contact Display View");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
  }

  public void createLabels() {
    labelPanel = new JPanel();
    labelPanel.setLayout(new GridLayout(5, 1));

    JLabel firstName = new JLabel("First Name");
    JLabel middleName = new JLabel("Middle Name");
    JLabel lastName = new JLabel("Last Name");
    JLabel emailLabel = new JLabel("Email");
    JLabel majorLabel = new JLabel("Major");

    labelPanel.add(firstName);
    labelPanel.add(middleName);
    labelPanel.add(lastName);
    labelPanel.add(emailLabel);
    labelPanel.add(majorLabel);
    
    frame.add(labelPanel, BorderLayout.LINE_START);
  }

  public void createTextBoxes() {
    textBoxPanel = new JPanel();
    textBoxPanel.setLayout(new GridLayout(5, 1));

    JTextField firstNameBox = new JTextField();
    JTextField middleNameBox = new JTextField();
    JTextField lastNameBox = new JTextField();
    JTextField emailBox = new JTextField();
    JTextField majorBox = new JTextField();

    textBoxPanel.add(firstNameBox);
    textBoxPanel.add(middleNameBox);
    textBoxPanel.add(lastNameBox);
    textBoxPanel.add(emailBox);
    textBoxPanel.add(majorBox);
    
    frame.add(textBoxPanel, BorderLayout.CENTER);
  }

  public void createButtons(){
    buttonsPanel = new JPanel();
    nextButton = new JButton("Next");
    previousButton = new JButton("Previous");
    
    buttonsPanel.add(previousButton, BorderLayout.LINE_START);
    buttonsPanel.add(nextButton, BorderLayout.LINE_END);
    
    frame.add(buttonsPanel, BorderLayout.PAGE_END);
  }
  
  public void createMenu(){
    menuBar = new JMenuBar();
    file = new JMenu("File");
    edit = new JMenu("Edit");
    
    menuBar.add(file, BorderLayout.WEST);
    menuBar.add(edit, BorderLayout.CENTER);
    
    frame.add(menuBar, BorderLayout.PAGE_START);
  }
  public void displayUI() {
    frame.setVisible(true);
  }

}
