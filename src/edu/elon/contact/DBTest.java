package edu.elon.contact;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// WARNING: THIS TEST CLASS EDITS THE DATABASE. Couldn't figure out how to do virtualization of SQL script on my own, and can't
// use code that either Jacob or myself did not write, obviously.

// Best way to test this right now is create a SEPARATE test database on your own server, and run the sqlscript that Jacob
// wrote for this project so it is ready to be worked with in the same way as original.

/*
 * Copyright (c) 2016 Jake Wells and Mitch Thompson
 * 
 */

public class DBTest {
	
	private Contact contact;
	private static String connString;
	private static Connection conn;
	private static String userName;
	private static String passWord;
	private static String ip;
	private static String databaseName;
	
	
	
	
	@BeforeClass
	public static void userPrompt(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Username for database connection: ");
		userName = s.nextLine();
		System.out.println("Enter Password for database connection: ");
		passWord = s.nextLine();
		System.out.println("Enter IP of database: ");
		ip = s.nextLine();
		System.out.println("Enter name of database to work with. Non-test is contactBook.");
		System.out.println("Only use if you are OK with editions. Otherwise make a test database with same fields manually. --");
		databaseName = s.nextLine();
		
		connString = "jdbc:mysql://" + ip + "/" + databaseName;
		s.close();
		
		try {
			conn = SQLDatabaseConnector.connectToDatabase(connString, userName, passWord);
		} catch (SQLException e) {
			System.out.println("SQL Error!");
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() throws Exception {
		contact = new Contact("Mitchell","G","Thompson","mthompson31@elon.edu","Computer Science");
	}
	
	@After
	public void tearDown() throws Exception {
		contact = null;
	}
	
	@AfterClass
	public static void tearDownAfter() throws Exception {
		connString = null;
		conn = null;
		userName = null;
		passWord = null;
		ip = null;
		databaseName = null;
	}

	@Test
	public void testAddContact() throws SQLException {
		SQLDatabaseConnector.createNewContact(conn, contact);
		 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		 ResultSet rs = stmt.executeQuery("SELECT * FROM contact WHERE FirstName = 'Mitchell'");
		 rs.next();
		 String email = rs.getString(5);
		 assertEquals(email, "mthompson31@elon.edu");
	}
	
	@Test
	public void testUpdateContact() throws SQLException {
		contact.setMajor("Chemistry");
		SQLDatabaseConnector.updateContact(conn, contact);
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		 ResultSet rs = stmt.executeQuery("SELECT * FROM contact WHERE FirstName = 'Mitchell'");
		 rs.next();
		 String major = rs.getString(6);
		 assertEquals(major, "Chemistry");
		//add code (usually SELECT statement) for checking editions are made, then assert value of statement
	}
	
	@Test
	public void testRemoveContact() throws SQLException {
		SQLDatabaseConnector.deleteContact(conn, contact);
		//add code (usually SELECT statement) for checking editions are made, then assert value of statement
	}
	
	@Test
	public void testDeleteAllContacts() throws SQLException{
		SQLDatabaseConnector.deleteAllContacts(conn);
		//add code (usually SELECT statement) for checking editions are made, then assert value of statement
	}

}
