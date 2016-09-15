package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Copyright (c) 2016 Jake Wells and Mitch Thompson
 * 
 */
public class UIActionListener implements ActionListener {

  private ContactUI myUI = ContactApplication.myUI;
  public static Connection conn;
  public static Contact current;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Exit")) {
      myUI.closeUI();
      try {
        conn.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }

    } else if (e.getActionCommand().equals("Connect")) {

      myUI.createLabels(2);
      myUI.createTextBoxes(ContactApplication.defaultOrCurrent);
      myUI.createButtons(2);
      myUI.displayUI();

    } else if (e.getActionCommand().equals("Clear DB")) {
      try {
        SQLDatabaseConnector.deleteAllContacts(conn);
        myUI.createTextBoxes(0);
        myUI.displayUI();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("Add")) {

      current = myUI.grabInputAsContact();
      
      myUI.createTextBoxes(0);
      myUI.createButtons(3);
      myUI.displayUI();

    } else if (e.getSource().equals(myUI.buttonOK)) {
      try {
        SQLDatabaseConnector.createNewContact(conn, myUI.grabInputAsContact());
        myUI.createButtons(1);
        myUI.createTextBoxes(0);
        myUI.displayUI();
        myUI.firstBox.setText(current.getFirstName());
        myUI.secondBox.setText(current.getMiddleName());
        myUI.thirdBox.setText(current.getLastName());
        myUI.fourthBox.setText(current.getEmail());
        myUI.fifthBox.setText(current.getMajor());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("Cancel")) {
      myUI.createButtons(1);
      myUI.createTextBoxes(0);
      myUI.displayUI();
      myUI.firstBox.setText(current.getFirstName());
      myUI.secondBox.setText(current.getMiddleName());
      myUI.thirdBox.setText(current.getLastName());
      myUI.fourthBox.setText(current.getEmail());
      myUI.fifthBox.setText(current.getMajor());

    } else if (e.getActionCommand().equals("Remove")) {
      try {
        SQLDatabaseConnector.deleteContact(conn, myUI.grabInputAsContact());

      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("Update")) {
      try {

        SQLDatabaseConnector.updateContact(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("OK")) {
      String connString = "jdbc:mysql://" + myUI.thirdBox.getText() + "/" + myUI.fourthBox.getText();
      try {
        conn = SQLDatabaseConnector.connectToDatabase(connString, myUI.firstBox.getText(), myUI.secondBox.getText());

        ContactApplication.currentUser = myUI.firstBox.getText();
        ContactApplication.currentPass = myUI.secondBox.getText();
        ContactApplication.currentIP = myUI.thirdBox.getText();
        ContactApplication.currentDB = myUI.fourthBox.getText();
        ContactApplication.currentTable = myUI.fifthBox.getText();
        ContactApplication.defaultOrCurrent = 2;
        SQLDatabaseConnector.displayFirst(conn);
        myUI.enableMenuItems();
        myUI.createLabels(1);
        myUI.createButtons(1);
        myUI.displayUI();
      } catch (SQLException e1) {
        myUI.connectionToDBFailed();
      }
    } else if (e.getActionCommand().equals("Next")) {
      try {
        SQLDatabaseConnector.displayNext(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("Previous")) {
      try {
        SQLDatabaseConnector.displayPrevious(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
  }
}
