package edu.elon.contact;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ContactUI {

  private JFrame frame;
  private JPanel labelPanel;
  private JPanel panel;
  private JPanel buttonPanel;
  private JButton button;
  private JMenuBar menuBar;
  private JMenu menu;
  private JMenuItem menuItem;
  protected JTextField firstNameBox;
  protected JTextField middleNameBox;
  protected JTextField lastNameBox;
  protected JTextField emailBox;
  protected JTextField majorBox;
  

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
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    panel = new JPanel();
    panel.setLayout(new GridLayout(5, 1));

    firstNameBox = new JTextField();
    middleNameBox = new JTextField();
    lastNameBox = new JTextField();
    emailBox = new JTextField();
    majorBox = new JTextField();

    panel.add(firstNameBox);
    panel.add(middleNameBox);
    panel.add(lastNameBox);
    panel.add(emailBox);
    panel.add(majorBox);
    
    frame.add(panel, BorderLayout.CENTER);
  }

  public void createButtons(){
    buttonPanel = new JPanel();
    
    button = new JButton("Next");
    buttonPanel.add(button, BorderLayout.LINE_END);
    
    button = new JButton("Previous");
    buttonPanel.add(button, BorderLayout.LINE_START);
    
    frame.add(buttonPanel, BorderLayout.PAGE_END);
  }
  
  public void createMenu(){
    menuBar = new JMenuBar();
    
    menu = new JMenu("File");
    menu.setMnemonic(KeyEvent.VK_F);
    
    menuItem = new JMenuItem("Clear DB", KeyEvent.VK_C);
    menuItem.addActionListener(new UIActionListener());
    menuItem.setEnabled(false);
    menu.add(menuItem);
    menuItem = new JMenuItem("Connect", KeyEvent.VK_T);
    menuItem.addActionListener(new UIActionListener());
    menu.add(menuItem);
    menu.addSeparator();
    menuItem = new JMenuItem("Exit", KeyEvent.VK_X);
    menuItem.addActionListener(new UIActionListener());
    menu.add(menuItem);
    
    menuBar.add(menu, BorderLayout.WEST);
    
    
    
    menu = new JMenu("Edit");
    menu.setMnemonic(KeyEvent.VK_E);
    
    menuItem = new JMenuItem("Add", KeyEvent.VK_A);
    menuItem.setEnabled(false);
    menu.add(menuItem);
    menuItem = new JMenuItem("Remove", KeyEvent.VK_R);
    menuItem.setEnabled(false);
    menu.add(menuItem);
    menuItem = new JMenuItem("Update", KeyEvent.VK_U);
    menuItem.setEnabled(false);
    menu.add(menuItem);
    
    menuBar.add(menu, BorderLayout.CENTER);
    
    
    
    frame.add(menuBar, BorderLayout.PAGE_START);
  }
  
  public Contact grabInputAsContact(){
	  Contact c = new Contact();
	  c.setFirstName(firstNameBox.getText());
	  c.setMiddleName(middleNameBox.getText());
	  c.setLastName(lastNameBox.getText());
	  c.setEmail(emailBox.getText());
	  c.setMajor(majorBox.getText());
	  return c;
  }
  
  public void connectToDB(){
    labelPanel.removeAll();
//    labelPanel = new JPanel();
//    labelPanel.setLayout(new GridLayout(5, 1));

    JLabel userName = new JLabel("User Name");
    JLabel Password = new JLabel("Password");
    JLabel IP = new JLabel("IP Address");
    JLabel DBName = new JLabel("Database Name");
    JLabel tableName = new JLabel("Table Name");

    labelPanel.add(userName);
    labelPanel.add(Password);
    labelPanel.add(IP);
    labelPanel.add(DBName);
    labelPanel.add(tableName);
    
    frame.add(labelPanel, BorderLayout.LINE_START);
    
    button = new JButton("OK");
    button.addActionListener(new UIActionListener());
    buttonPanel.removeAll();
    buttonPanel.add(button);

  }
  public void unableToConnectUI(){
    JOptionPane.showMessageDialog(null, "You did not correctly specify DB paramaters", "alert", JOptionPane.ERROR_MESSAGE);
  }
  public void close(){
    frame.dispose();
  }
  public void displayUI() {
    frame.setVisible(true);
  }

}
