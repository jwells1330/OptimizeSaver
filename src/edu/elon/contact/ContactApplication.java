package edu.elon.contact;

public class ContactApplication {

  protected static String currentUser;
  protected static String currentPass;
  protected static String currentIP;
  protected static String currentDB;
  protected static String currentTable;
  protected static int defaultOrCurrent = 1;
  
  public static ContactUI myUI;
  
  public static void main(String[] args){
    myUI = new ContactUI();
    
    myUI.createFrame();
    myUI.createLabels(1);
    myUI.createTextBoxes(0);
    myUI.createButtons(1);
    myUI.createMenu();
    myUI.displayUI();
  }
}
