package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Connect")){
      System.out.println("test");
      ContactUI myUI = ContactApplication.myUI;
      myUI.connectToDB();
      myUI.displayUI();
    }else if(e.getActionCommand().equals("OK")){
    	
    }
    
  }

}
