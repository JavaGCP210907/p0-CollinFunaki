package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.GamesDAO;
import com.revature.dao.UsersDAO;

public class Menu {
	
	UsersDAO uDao = new UsersDAO(); 
	GamesDAO gDao = new GamesDAO();
	//Logger object so we can implement logging
	Logger log = LogManager.getLogger(Menu.class); // 
	
	public void displayMenu() {
		
		boolean displayMenu = true; ///we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in);
		
		//pretty greeting :)
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to the Funaki Sportsbook!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//display the menu as long as displayMenu boolean is true
		while(displayMenu) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Choose an option");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			//menu options
			System.out.println("account -> view balance");
			System.out.println("games -> view games and bets");
			System.out.println("place bet -> place a bet");
			System.out.println("deposit -> add money to account balance");
			System.out.println("withdraw -> withdraw account balance");
			
			System.out.println("exit -> exit application");
			
			//parse user inputs after they choose a menu option
			String input = scan.nextLine();
			
			//switch statement that takes the input and delivers the appropriate response
			//you may have a hard time reading all this functionality
			//look at our dao layer interfaces to see everything the CLI is able to do
			
			switch(input) {
			
			case "account": {
				//get the account of the user from the DAO layer
				System.out.println("What is your account id?");
				int idInput = scan.nextInt();
				scan.nextLine(); // we still need nextLine so that we can move the next line for more input
				
				//what if user inputs a string> program crashes -- up t you to add fool proof mechanisms
				
				List<Users> users = uDao.getAccount(idInput);
				
				for(Users u : users) {
					System.out.println(u);
				}
				
				break;	
			}
			
			
			case "exit":{
				displayMenu = false; //this is how break out of while loop
				System.out.println("Good Bye!");
				break;
			}
			
			//this default block will catch anything that doesn't match a menu option
			default: {
				System.out.println("Invalid Entry. Please try again.");
			}
			}//switch ends here
		
		}///while loop ends here
		
		System.out.println("Thank you for using the Funaki Sportsbook");
		scan.close(); //closes the Scanner, good for memory saving
	
	}
}
