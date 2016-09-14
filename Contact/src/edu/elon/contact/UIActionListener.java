package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UIActionListener implements ActionListener {


  private ContactUI myUI = ContactApplication.myUI;
	
	
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Connect")){
      
      myUI.connectToDB();
      myUI.displayUI();
    }else if(e.getActionCommand().equals("OK")){
    	
    	//not sure if I am on the right track here, but seems so
    	try {
    	  System.out.println("Connecting to Database");
    	  String connString = "jdbc:mysql://" + myUI.lastNameBox.getText() + "/" + myUI.emailBox.getText();
			SQLDatabaseConnector.connectToDatabase(connString, myUI.firstNameBox.getText(), myUI.middleNameBox.getText());
		} catch (SQLException e1) {
			myUI.unableToConnectUI();
		}
    	
    }
    
  }

}
