package edu.elon.contact;

import java.sql.Connection;
import java.sql.SQLException;

public class ContactApplication {
  public static ContactUI myUI;
  
  public static void main(String[] args) throws SQLException {
    createUI();
    createDB();
  }

  private static void createDB() throws SQLException {
    //SQLDatabaseConnector myDatabaseConnector = new SQLDatabaseConnector();
    Connection conn = SQLDatabaseConnector.connectToDatabase();
  }

  private static void createUI() {
    myUI = new ContactUI();
    myUI.createUI();
    myUI.displayUI();
  }

}
