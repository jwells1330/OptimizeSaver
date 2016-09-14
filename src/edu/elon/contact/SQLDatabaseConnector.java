package edu.elon.contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDatabaseConnector {

  public static String defaultUser = "jwells1330";
  public static String defaultPass = "Tw0C0ins";
  public static String defaultIP = "localhost";
  public static String defaultDB = "contactBook";
  public static String defaultTable = "contact";

  public SQLDatabaseConnector() {

  }

  public static void deleteAllContacts(Connection conn) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement();
    stmt.executeUpdate("DELETE FROM CONTACT");
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
}
