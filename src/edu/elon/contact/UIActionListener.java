package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class UIActionListener implements ActionListener{

  private ContactUI myUI = ContactApplication.myUI;
  private Connection conn;
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Exit")){
      myUI.closeUI();
    }else if(e.getActionCommand().equals("Clear DB")){
      try {
        SQLDatabaseConnector.deleteAllContacts(conn);
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }else if(e.getActionCommand().equals("Add")){
      try {
        SQLDatabaseConnector.createNewContact(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }else if(e.getActionCommand().equals("Remove")){
      try {
        SQLDatabaseConnector.deleteContact(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }else if(e.getActionCommand().equals("Update")){
      try {
        SQLDatabaseConnector.updateContact(conn, myUI.grabInputAsContact());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }else if(e.getActionCommand().equals("OK")){
      System.out.println("Connecting to Database");
      String connString = "jdbc:mysql://" + myUI.thirdBox.getText() + "/" + myUI.fourthBox.getText();
      try {
        conn = SQLDatabaseConnector.connectToDatabase(connString, myUI.firstBox.getText(), myUI.secondBox.getText());
        SQLDatabaseConnector.displayAllContacts(conn);
      } catch (SQLException e1) {
        myUI.connectionToDBFailed();
      }
    }
    
    
  }

}
