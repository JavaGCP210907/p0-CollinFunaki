package com.revature.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//this class is where we manage and establish our connection
public class ConnectionUtil {
	
	//this method will return an object of type connection which wel'll use to connect to our database
	public static Connection getConnection()  throws SQLException{
	
	//for compatibility with other technologies/frameworks, we'll need to register our PostgreSQL driver
	//this process makes the application aware of what driver class we're using
	try {
		Class.forName("org.postgresql.Driver"); //searching for the postgre driver, which we have as a depenedency
	} catch (ClassNotFoundException e) {
		e.printStackTrace(); //this tells in the console us what went wrong
	}
	
	
	//use our database credentials to establish a database connection
	
	//BELOW is how you establish database connection with credetials -- without hardcoding
	//these varaiblse are hidden in my environment varaibles
	//run -> run configurations -> environment (may have to stretch out window) -> then create key/value pairs for these credentials 
	String url = System.getenv("url");
	String username = System.getenv("username");
	String password = System.getenv("password");
	
	//this return statement is a what returns our actual database connection object
	//note how this getConnection() method has a return type of connection
	return DriverManager.getConnection(url, username, password);
	
	}
}
