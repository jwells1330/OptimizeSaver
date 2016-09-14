package edu.elon.contact;

public class ContactApplication {

  public static String currentUser;
  public static String currentPass;
  public static String currentIP;
  public static String currentDB;
  public static String currentTable;
  
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
