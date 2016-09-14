package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class UIActionListener implements ActionListener {

  private ContactUI myUI = ContactApplication.myUI;
  private Connection conn;
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Connect")) {
      myUI.firstNameBox.setText("jwells1330");
      myUI.middleNameBox.setText("Tw0C0ins");
      myUI.lastNameBox.setText("localhost");
      myUI.emailBox.setText("contactBook");
      myUI.majorBox.setText("contact");
      
      myUI.connectToDB();
      myUI.displayUI();
    } else if (e.getActionCommand().equals("OK")) {
      try {
        System.out.println("Connecting to Database");
        String connString = "jdbc:mysql://" + myUI.lastNameBox.getText() + "/" + myUI.emailBox.getText();
        conn = SQLDatabaseConnector.connectToDatabase(connString, myUI.firstNameBox.getText(), myUI.middleNameBox.getText());
        
        SQLDatabaseConnector.displayAllContacts(conn);
        
        myUI.createLabels();
        myUI.createButtons();
        myUI.displayUI();
        
      } catch (SQLException e1) {
        myUI.unableToConnectUI();
      }

    }
    else if(e.getActionCommand().equals("Exit")){
      myUI.close();
    }
    else if(e.getActionCommand().equals("Clear DB")){
      try {
        SQLDatabaseConnector.deleteAllContacts(conn);
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    }
    

  }

}
