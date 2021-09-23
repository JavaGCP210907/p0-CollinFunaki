package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.GamesDAO;
import com.revature.dao.UserBetsDAO;
import com.revature.dao.UsersDAO;

public class Menu {
	
	UsersDAO uDao = new UsersDAO(); 
	GamesDAO gDao = new GamesDAO();
	UserBetsDAO bDao = new UserBetsDAO();
	//Logger object so we can implement logging
	Logger log = LogManager.getLogger(Menu.class); // 
	
	public void displayMenu() {
		
		boolean displayMenu = true; ///we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in);
		
		//pretty greeting :)
		System.out.println("*********************************************************");
		System.out.println();
		System.out.println("Welcome to the Funaki Sportsbook!");
		System.out.println();
		System.out.println("*********************************************************");
		
		//display the menu as long as displayMenu boolean is true
		while(displayMenu) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Choose an option by entering a command below");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			//menu options
			System.out.println("account -> view account info");
			System.out.println("my bets -> view my bets");
			System.out.println("games -> view games to bet on");
			System.out.println("place bet -> place a bet");
			System.out.println("update bet -> update a bet");
			System.out.println("cancel bet -> cancel a bet");
			System.out.println("exit -> exit application");
			
			//parse user inputs after they choose a menu option
			System.out.println("Type entry here: ");
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
				
				log.info("User viewed account");
				
				break;	
			}
			
			case "games": {
				//get the List of employees from the DAO layer
				List<Games> games = gDao.getGames();
				
				//enhanced for loop tp print out employees line by line
				for(Games g : games) {
					System.out.println(g);
				}
				
				log.info("User retireved list of all games");
				
				break;			
			}
			
			
			case "place bet":{
				
				System.out.println("Enter your user ID.");
				int userId = scan.nextInt();
				
				System.out.println("Enter game id.");
				int gameId = scan.nextInt();
				
				System.out.println("What type of bet would you like to place (spread or over/under)?");
				String type = scan.nextLine();
				scan.nextLine();
				
				System.out.println("What is the bet you would like to place?");
				String bet = scan.nextLine();
				
				System.out.println("How much money would you like to bet?");
				int amount = scan.nextInt();
				
				//create a new User bet based on these inputs
				UserBets b = new UserBets(userId, gameId, type, bet, amount);
				
				
				bDao.placeBet(b);
				
				log.info("User placed a bet");
				
				break;
				
			}
			
			case "my bets": {
				//get the account of the user from the DAO layer
				System.out.println("What is your account id?");
				int id = scan.nextInt();
				scan.nextLine(); // we still need nextLine so that we can move the next line for more input
				
				//what if user inputs a string> program crashes -- up t you to add fool proof mechanisms
				
				List<UserBets> bets = bDao.getBets(id);
				
				for(UserBets b : bets) {
					System.out.println(b);
				}
				
				log.info("User viewed their bets");
				
				break;	
			}
			
			
			case "update bet":{
				
				System.out.println("Enter the bet id of the bet you would like to change");
				int id = scan.nextInt();
				
				System.out.println("Enter the updated amount($) you want for your bet");
				int updatedAmount = scan.nextInt();
				scan.nextLine();
				
				bDao.updateBet(id, updatedAmount);
				
				log.warn("You updated bet #" + id);
				break;
				
			}
			
			
			case "cancel bet":{
				
				System.out.println("Enter the id of the bet to cancel");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				bDao.cancelBet(id);
				
				log.warn("You deleted bet #" + id);
				
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
				
				log.warn("There was an invalid entry");
			}
			}//switch ends here
		
		}///while loop ends here
		
		System.out.println("Thank you for using the Funaki Sportsbook!");
		scan.close(); //closes the Scanner, good for memory saving
		log.info("Session ended");
	
	}
}
