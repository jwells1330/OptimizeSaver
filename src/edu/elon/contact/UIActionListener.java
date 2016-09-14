package edu.elon.contact;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIActionListener implements ActionListener{

  private ContactUI myUI = ContactApplication.myUI;
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Exit")){
      myUI.closeUI();
    }else if(e.getActionCommand().equals("Connect")){
        
        myUI.createLabels(2);
        myUI.createTextBoxes(2);
        myUI.createButtons(2);
        myUI.displayUI();
        
    }
    
    
    
    
  }

}
