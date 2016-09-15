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

  public static void deleteAllContacts(Connection conn) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement();
    stmt.executeUpdate("DELETE FROM CONTACT");
    stmt.close();
  }

  public static void createNewContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    System.out.println("INSERT INTO contact " + "(FirstName, MiddleName, LastName, Email, Major) " + "VALUES ("
    + contact.toString() + " )");
    
    stmt.executeUpdate("INSERT INTO contact " + "(FirstName, MiddleName, LastName, Email, Major) " + "VALUES ("
        + contact.toString() + " )");

    stmt.close();
  }

  public static void deleteContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    boolean moved = displayNext(conn, contact);
    if(moved){
      stmt.executeUpdate("DELETE FROM contact " + "WHERE email = '" + contact.getEmail() + "'");
    }else{
      displayPrevious(conn, contact);
      stmt.executeUpdate("DELETE FROM contact " + "WHERE email = '" + contact.getEmail() + "'");
    }

    stmt.close();

  }

  public static void updateContact(Connection conn, Contact contact) throws SQLException {
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

    stmt.executeUpdate("UPDATE contact SET FirstName = '" + contact.getFirstName() + "', MiddleName = '"
        + contact.getMiddleName() + "', LastName = '" + contact.getLastName() + "', Email = '" + contact.getEmail()
        + "', Major = '" + contact.getMajor() + "' WHERE FirstName = '" + contact.getFirstName()
        + "' OR " + "LastName = '" + contact.getLastName() + "' OR " + "Email = '" + contact.getEmail() + "'");

    stmt.close();
  }

  public static boolean displayNext(Connection conn, Contact contact) throws SQLException {
    boolean moved = false;
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("SELECT * FROM contact");
    rs.next();
    while(rs.getString(5).compareTo(myUI.fourthBox.getText()) != 0){
      rs.next();
    }
    if(rs.next()){
      rs.previous();
      rs.next();
      moved = true;
    }
    if(rs.isAfterLast()){
      rs.previous();
      moved = false;
    }

    myUI.firstBox.setText(rs.getString(2));
    myUI.secondBox.setText(rs.getString(3));
    myUI.thirdBox.setText(rs.getString(4));
    myUI.fourthBox.setText(rs.getString(5));
    myUI.fifthBox.setText(rs.getString(6));

    rs.close();
    stmt.close();
    return moved;
  }

  public static void displayPrevious(Connection conn, Contact contact) throws SQLException {
    Statement stmt = null;
    stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery("SELECT * FROM contact");
    rs.next();
    while(rs.getString(5).compareTo(myUI.fourthBox.getText()) != 0){
      rs.next();
    }
    if(rs.previous()){
      rs.next();
      rs.previous();
    }
    if(rs.isBeforeFirst()){
      rs.next();
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
