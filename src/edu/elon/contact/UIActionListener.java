package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class UIActionListener implements ActionListener {

  private ContactUI myUI = ContactApplication.myUI;
  public static Connection conn;

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
        SQLDatabaseConnector.displayFirst(conn);
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } else if (e.getActionCommand().equals("Add")) {
      try {
        SQLDatabaseConnector.createNewContact(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
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

        myUI.enableMenuItems();
        myUI.createLabels(1);
        myUI.createButtons(1);
        myUI.displayUI();

        ContactApplication.currentUser = myUI.firstBox.getText();
        ContactApplication.currentPass = myUI.secondBox.getText();
        ContactApplication.currentIP = myUI.thirdBox.getText();
        ContactApplication.currentDB = myUI.fourthBox.getText();
        ContactApplication.currentTable = myUI.fifthBox.getText();
        ContactApplication.defaultOrCurrent = 2;
        
        SQLDatabaseConnector.displayFirst(conn);
      } catch (SQLException e1) {
        System.out.println(e1);
        myUI.connectionToDBFailed();
      }
    } else if (e.getActionCommand().equals("Next")) {
      try {
        System.out.println("Displaying Next");
        SQLDatabaseConnector.displayNext(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
  }
}
