package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UIActionListener implements ActionListener {


  private ContactUI myUI = ContactApplication.myUI;
	
	
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Connect")){
      System.out.println("test");
      
      myUI.connectToDB();
      myUI.displayUI();
    }else if(e.getActionCommand().equals("OK")){
    	
    	//not sure if I am on the right track here, but seems so
    	try {
    		//order of connstring, username, password boxes
			SQLDatabaseConnector.connectToDatabase(myUI.lastNameBox.getText(),myUI.firstNameBox.getText(),myUI.middleNameBox.getText());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    }
    
  }

}
