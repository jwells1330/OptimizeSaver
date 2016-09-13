package edu.elon.contact;

import java.sql.Connection;
import java.sql.SQLException;

public class ContactApplication {
  public static void main(String[] args) throws SQLException {
    createUI();
    createDB();
  }

  private static void createDB() throws SQLException {
    SQLDatabaseConnector myDatabaseConnector = new SQLDatabaseConnector();
    Connection conn = myDatabaseConnector.connectToDatabase();
  }

  private static void createUI() {
    ContactUI myUI = new ContactUI();
    myUI.createUI();
    myUI.displayUI();
  }

}
