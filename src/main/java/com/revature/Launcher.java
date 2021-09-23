package com.revature;

//import java.sql.Connection;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtil;

public class Launcher {
	
	public static void main(String[] args) {
		//testing whether our connection is successful
//		try(Connection conn = ConnectionUtil.getConnection()){
//			System.out.println("Hello, connection was successful!");
//		} catch (SQLException e) {
//			System.out.println("Hey connection failed!");
//			e.printStackTrace();
//		}
		
		//functionality of the application
		
		//create the menu object
		Menu menu = new Menu();
		
		//use the Menu's displayMenu() method to use the menu
		menu.displayMenu();
		
	}
		
}
