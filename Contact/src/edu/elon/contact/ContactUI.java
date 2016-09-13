package edu.elon.contact;

import java.awt.*;
import javax.swing.*;

public class ContactUI {

  private JFrame frame;
  private JPanel panel;
  private JPanel panel2;
  private Container container;
  private JMenu menu;
  private Dimension maximumSize;

  public ContactUI() {
  }

  public void createUI() {
    frame = new JFrame("Contact Display View");
    frame.setSize(400, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    frame.setLayout(new GridLayout(1,2));

    panel = new JPanel();
    panel2 = new JPanel();
    panel.setLayout(new GridLayout(5,1));
    panel2.setLayout(new GridLayout(5, 1));
    
    maximumSize = new Dimension(1, 1);
    
    JLabel firstName = new JLabel("First Name");
    JLabel middleName = new JLabel("Middle Name");
    JLabel lastName = new JLabel("Last Name");
    JLabel emailLabel = new JLabel("Email");
    JLabel majorLabel = new JLabel("Major");

    JTextField firstNameBox = new JTextField();
    JTextField middleNameBox = new JTextField();
    JTextField lastNameBox = new JTextField();
    JTextField emailBox = new JTextField();
    JTextField majorBox = new JTextField();

    // Container container = frame.getContentPane();
    // frame.add(container);

    // firstNameBox.setHorizontalAlignment(JTextField.RIGHT);
    // middleNameBox.setHorizontalAlignment(JTextField.RIGHT);
    // lastNameBox.setHorizontalAlignment(JTextField.RIGHT);
    // emailBox.setHorizontalAlignment(JTextField.RIGHT);
    // majorBox.setHorizontalAlignment(JTextField.RIGHT);

    firstName.setPreferredSize(maximumSize);
    panel.add(firstName);
    panel2.add(firstNameBox);
    
    
    panel.add(middleName);
    panel2.add(middleNameBox);
    
    panel.add(lastName);
    panel2.add(lastNameBox);
    
    panel.add(emailLabel);
    panel2.add(emailBox);
    
    panel.add(majorLabel);
    panel2.add(majorBox);
    
    panel.setPreferredSize(maximumSize);
    frame.add(panel);
    frame.add(panel2);
  }

  public void displayUI() {
    frame.setVisible(true);
  }

}
