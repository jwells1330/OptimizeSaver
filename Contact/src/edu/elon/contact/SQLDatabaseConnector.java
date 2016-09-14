package edu.elon.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLDatabaseConnector {

  private static ContactUI myUI = ContactApplication.myUI;

  public SQLDatabaseConnector() throws SQLException {
  }

  public static Connection connectToDatabase(String connString, String userName, String passWord) throws SQLException {

    Connection conn = null;

    conn = DriverManager.getConnection(connString, userName, passWord);
    // System.out.println("Succesfully Connected to Database!");
    return conn;
  }

  public static void displayAllContacts(Connection conn) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;

    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    rs = stmt.executeQuery("SELECT * FROM contact");
    rs.next();

    myUI.firstNameBox.setText(rs.getString(2));
    myUI.middleNameBox.setText(rs.getString(3));
    myUI.lastNameBox.setText(rs.getString(4));
    myUI.emailBox.setText(rs.getString(5));
    myUI.majorBox.setText(rs.getString(6));
    
    rs.close();
    stmt.close();

  }

  public static void createNewContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    stmt.executeUpdate("INSERT INTO contact" + "(FirstName,MiddleName,LastName,Email,Major) " + "Values" + "( "
        + contact.toString() + " )");

    stmt.close();

  }

  public static void deleteContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    String deleteFirstName = contact.getFirstName();
    String deleteLastName = contact.getLastName();

    stmt.executeUpdate(
        "DELETE FROM contact " + "WHERE firstName = '" + deleteFirstName + "' AND lastName = '" + deleteLastName + "'");
  }

  public static void updateContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    String deleteFirstName = contact.getFirstName();
    String deleteLastName = contact.getLastName();

    stmt.executeUpdate("UPDATE contact " + "SET" + "WHERE firstName = '" + deleteFirstName + "' AND lastName = '"
        + deleteLastName + "'");
  }

  public static void deleteAllContacts(Connection conn) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    stmt.executeUpdate("DELETE FROM contact");
  }

  public static Contact grabFirstContact(Connection conn) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    // implement code to get details of first entry as type Contact. Call this
    // in UI on button click to fill text fields.
    return null;
  }

  public static void closeConnection(Connection conn) throws SQLException {
    conn.close();
    System.out.println("Connection to Database Closed");
  }
}
