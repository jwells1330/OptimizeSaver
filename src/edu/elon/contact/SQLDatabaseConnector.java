package edu.elon.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLDatabaseConnector {

  public static final String defaultUser = "jwells1330";
  public static final String defaultPass = "Tw0C0ins";
  public static final String defaultIP = "localhost";
  public static final String defaultDB = "contactBook";
  public static final String defaultTable = "contact";

  public static ContactUI myUI = ContactApplication.myUI;
      
  public SQLDatabaseConnector() {

  }
  
  public static Connection connectToDatabase(String connString, String userName, String passWord) throws SQLException {

    Connection conn = null;
    conn = DriverManager.getConnection(connString, userName, passWord);
    return conn;
  }
  
  public static void displayFirst(Connection conn) throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;

    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    rs = stmt.executeQuery("SELECT * FROM contact");
    rs.next();
    

    myUI.firstBox.setText(rs.getString(2));
    myUI.secondBox.setText(rs.getString(3));
    myUI.thirdBox.setText(rs.getString(4));
    myUI.fourthBox.setText(rs.getString(5));
    myUI.fifthBox.setText(rs.getString(6));
    
    rs.close();
    stmt.close();

  }
  
  public static ArrayList<Contact> giveList(){
	  return null;
  }
  
  public static void deleteAllContacts(Connection conn) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement();
    stmt.executeUpdate("DELETE FROM CONTACT");
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
    stmt.close();
  }

  public static void updateContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    String deleteFirstName = contact.getFirstName();
    String deleteLastName = contact.getLastName();

    stmt.executeUpdate("UPDATE contact " + "SET" + " FirstName = '" + deleteFirstName + "', LastName = '"
        + deleteLastName + "'");
    stmt.close();
  }
  public static void displayNext(Connection conn, Contact contact) throws SQLException{
    Statement stmt = null;
    ResultSet rs = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    rs = stmt.executeQuery("SELECT ContactId FROM contact WHERE Email = '" + myUI.fourthBox.getText() + "'");
    rs.next();
    int current = rs.getInt(1);
    rs = stmt.executeQuery("SELECT * FROM contact");
    rs.last();
    int max = rs.getRow();
    if(current<max){
      rs.absolute(current+1);
    }

    myUI.firstBox.setText(rs.getString(2));
    myUI.secondBox.setText(rs.getString(3));
    myUI.thirdBox.setText(rs.getString(4));
    myUI.fourthBox.setText(rs.getString(5));
    myUI.fifthBox.setText(rs.getString(6));
    
    rs.close();
    stmt.close();
  }
  
  
  
}
