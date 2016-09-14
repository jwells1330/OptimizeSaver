package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIActionListener implements ActionListener{

  private ContactUI myUI = ContactApplication.myUI;
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Exit")){
      myUI.closeUI();
    }
    
  }

}
