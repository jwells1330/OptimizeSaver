package edu.elon.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnector {

  public static final String defaultUser = "jwells1330";
  public static final String defaultPass = "Tw0C0ins";
  public static final String defaultIP = "localhost";
  public static final String defaultDB = "contactBook";
  public static final String defaultTable = "contact";
  
  public SQLDatabaseConnector(){
    
  }
  
  public static Connection connectToDatabase(String connString, String userName, String passWord) throws SQLException {

	    Connection conn = null;
	    
	    try {
	      conn = DriverManager.getConnection(connString, userName, passWord);
	      System.out.println("Succesfully Connected to Database!");
	    } catch (SQLException e) {
	      // System.err.println(e);
	      System.out.println("Connection Failed: Incorrect db parameters");
	    }
	    return conn;
	  }
  
}
