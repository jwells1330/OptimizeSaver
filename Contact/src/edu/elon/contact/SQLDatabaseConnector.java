package edu.elon.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLDatabaseConnector {
	
	private static final String USERNAME = "jwells1330";
	private static final String PASSWORD = "Tw0C0ins";
	private static final String CONN_STRING = "jdbc:mysql://localhost/contactBook";
	
	private static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException{
		Connection conn = connectToDatabase();

		
		if (conn != null){
			
			//createNewContact(conn);
			deleteContact(conn);
			displayAllContacts(conn);
			closeConnection(conn);
		}
	}
	
	public static Connection connectToDatabase() throws SQLException{
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Succesfully Connected to Database!");
		} catch (SQLException e) {
			//System.err.println(e);
			System.out.println("Connection Failed: Incorrect db paramaters");
		}
		return conn;
	}
	public static void displayAllContacts(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery("SELECT * FROM contact");
		while(rs.next()){
			rs.previous();
			System.out.println("Forward or Back?");
			String next = in.nextLine();
			if (next.contains("f")||next.contains("F")){
				rs.next();
				String firstName = rs.getString(2);
				String middleName = rs.getString(3);
				String lastName = rs.getString(4);
				String email = rs.getString(5);
				String major = rs.getString(6);
				
				System.out.println("First Name: " + firstName);
				System.out.println("Middle Name: " + middleName);
				System.out.println("Last Name: " + lastName);
				System.out.println("Email: " + email);
				System.out.println("Major: " + major);
				System.out.println();
			}
		}
		rs.close();
		stmt.close();	
	}
	public static void createNewContact(Connection conn)throws SQLException{
		Statement stmt = null;
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		String newFirstName = "Jacob ";
		String newMiddleName = "Michael ";
		String newLastName = "Wells ";
		String newEmail = "jwells8@elon.edu ";
		String newMajor = "CS ";
		
		
		stmt.executeUpdate("INSERT INTO contact"
				+ "(FirstName,MiddleName,LastName,Email,Major) " + "Values"
				+ "('" + newFirstName + "', '" + newMiddleName + "', '" + newLastName + "', '" 
				+ newEmail + "', '" + newMajor + "')");
		
		stmt.close();
		
	}
	public static void deleteContact(Connection conn)throws SQLException{
		Statement stmt = null;
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		String deleteFirstName = "Jacob";
		String deleteLastName = "Wells";
		
		stmt.executeUpdate("DELETE FROM contact "
				+ "WHERE firstName = '" + deleteFirstName + "' AND lastName = '" + deleteLastName +"'");
	}
	public static void updateContact(Connection conn)throws SQLException{
		Statement stmt = null;
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		String deleteFirstName = "Jacob";
		String deleteLastName = "Wells";
		
		stmt.executeUpdate("UPDATE contact "
				+ "SET"
				+ "WHERE firstName = '" + deleteFirstName + "' AND lastName = '" + deleteLastName +"'");
	}
	public static void closeConnection(Connection conn) throws SQLException{
		conn.close();
		System.out.println("Connection to Database Closed");
	}
}
