package edu.elon.contact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


/*
 * Copyright (c) 2016 Jake Wells and Mitch Thompson
 * 
 */
public class ContactUI {

  private JFrame mainFrame;
  private JPanel labelPanel = new JPanel();
  private JPanel textPanel = new JPanel();
  private JPanel buttonPanel = new JPanel();
  private JMenuBar menuBar = new JMenuBar();

  private JButton button;
  private JMenu menu;
  private JMenuItem menuItem;

  private boolean enabled;

  protected JButton buttonOK;
  protected JTextField firstBox;
  protected JTextField secondBox;
  protected JTextField thirdBox;
  protected JTextField fourthBox;
  protected JTextField fifthBox;

  public ContactUI() {
  }

  public void createFrame() {
    mainFrame = new JFrame("Contact Display View");
    mainFrame.setSize(400, 200);
    mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);

  }

  public void createLabels(int type) {
    labelPanel.removeAll();
    labelPanel.setLayout(new GridLayout(5, 1));
    JLabel firstLabel = new JLabel();
    JLabel secondLabel = new JLabel();
    JLabel thirdLabel = new JLabel();
    JLabel fourthLabel = new JLabel();
    JLabel fifthLabel = new JLabel();

    if (type == 1) {
      firstLabel.setText("First Name");
      secondLabel.setText("Middle Name");
      thirdLabel.setText("Last Name");
      fourthLabel.setText("Email");
      fifthLabel.setText("Major");
    } else if (type == 2) {
      firstLabel.setText("Username");
      secondLabel.setText("Password");
      thirdLabel.setText("IP Address");
      fourthLabel.setText("DB Name");
      fifthLabel.setText("Table Name");
    }

    labelPanel.add(firstLabel);
    labelPanel.add(secondLabel);
    labelPanel.add(thirdLabel);
    labelPanel.add(fourthLabel);
    labelPanel.add(fifthLabel);

    mainFrame.add(labelPanel, BorderLayout.LINE_START);
  }

  public void createTextBoxes(int type) {
    textPanel.removeAll();
    textPanel.setLayout(new GridLayout(5, 1));
    firstBox = new JTextField();
    secondBox = new JTextField();
    thirdBox = new JTextField();
    fourthBox = new JTextField();
    fifthBox = new JTextField();
    if (type == 0) {
      firstBox.setText("");
      secondBox.setText("");
      thirdBox.setText("");
      fourthBox.setText("");
      fifthBox.setText("");
    } else if (type == 1) {
      firstBox.setText(SQLDatabaseConnector.defaultUser);
      secondBox.setText(SQLDatabaseConnector.defaultPass);
      thirdBox.setText(SQLDatabaseConnector.defaultIP);
      fourthBox.setText(SQLDatabaseConnector.defaultDB);
      fifthBox.setText(SQLDatabaseConnector.defaultTable);
    } else if (type == 2) {
      firstBox.setText(ContactApplication.currentUser);
      secondBox.setText(ContactApplication.currentPass);
      thirdBox.setText(ContactApplication.currentIP);
      fourthBox.setText(ContactApplication.currentDB);
      fifthBox.setText(ContactApplication.currentTable);
    }
    textPanel.add(firstBox);
    textPanel.add(secondBox);
    textPanel.add(thirdBox);
    textPanel.add(fourthBox);
    textPanel.add(fifthBox);
    mainFrame.add(textPanel, BorderLayout.CENTER);
  }

  public void createButtons(int type) {
    buttonPanel.removeAll();
    if (type == 1) {
      button = new JButton("Next");
      buttonPanel.add(button, BorderLayout.LINE_END);
      button.addActionListener(new UIActionListener());
      button = new JButton("Previous");
      buttonPanel.add(button, BorderLayout.LINE_START);
      button.addActionListener(new UIActionListener());
    } else if (type == 2) {
      button = new JButton("OK");
      button.addActionListener(new UIActionListener());
      buttonPanel.add(button);
    } else if (type == 3) {
      buttonOK = new JButton("OK");
      buttonOK.addActionListener(new UIActionListener());
      buttonPanel.add(buttonOK, BorderLayout.LINE_END);  
      button = new JButton("Cancel");
      buttonPanel.add(button, BorderLayout.LINE_START);
      button.addActionListener(new UIActionListener());
    }

    mainFrame.add(buttonPanel, BorderLayout.PAGE_END);
  }

  public void createMenu() {
    menuBar.removeAll();

    menu = new JMenu("File");
    menu.setMnemonic(KeyEvent.VK_F);

    menuItem = new JMenuItem("Clear DB", KeyEvent.VK_C);
    menuItem.addActionListener(new UIActionListener());
    menuItem.setEnabled(enabled);
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
    menuItem.addActionListener(new UIActionListener());
    menuItem.setEnabled(enabled);
    menu.add(menuItem);
    menuItem = new JMenuItem("Remove", KeyEvent.VK_R);
    menuItem.addActionListener(new UIActionListener());
    menuItem.setEnabled(enabled);
    menu.add(menuItem);
    menuItem = new JMenuItem("Update", KeyEvent.VK_U);
    menuItem.addActionListener(new UIActionListener());
    menuItem.setEnabled(enabled);
    menu.add(menuItem);
    menuBar.add(menu, BorderLayout.CENTER);
    mainFrame.add(menuBar, BorderLayout.PAGE_START);

  }

  public Contact grabInputAsContact() {
    Contact c = new Contact(firstBox.getText(),secondBox.getText(),thirdBox.getText(),fourthBox.getText(),fifthBox.getText());
    return c;
  }

  public void enableMenuItems() {
    enabled = true;
    createMenu();
  }

  public void displayUI() {
    mainFrame.setVisible(true);
  }

  public void connectionToDBFailed() {
    JOptionPane.showMessageDialog(null, "You did not correctly specify DB paramaters", "alert",
        JOptionPane.ERROR_MESSAGE);
  }

  public void closeUI() {
    mainFrame.dispose();
  }
}
