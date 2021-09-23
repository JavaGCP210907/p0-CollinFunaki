package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserBets;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UserBetsDAO implements UserBetsDAOInterface{

	//function to place a bet
	@Override
	public void placeBet(UserBets UserBet) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//you can line break a sql statement by contcatenation
			String sql = "insert into user_bets (user_id_fk, game_id_fk, bet_type, description, amount)" +
						"values (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, UserBet.getUser_id_fk());
			ps.setInt(2, UserBet.getGame_id_fk());
			ps.setString(3,  UserBet.getBet_type());
			ps.setString(4, UserBet.getDescription());
			ps.setInt(5, UserBet.getAmount());
			
			ps.executeUpdate(); //for anything that is NOT a SELECT statement, we use an executeUpdate()
			
			//send confirmation to the console if successful
			System.out.println("Your bet of $" + UserBet.getAmount() + " on "+ UserBet.getDescription() + " has been placed! Good Luck!");
			
			
		} catch (SQLException e) {
			System.out.println("Bet placement failed... please try again.");
			e.printStackTrace();
		}
		
		
	}
	
	
	//get bets under a particular user id
	@Override
	public List<UserBets> getBets(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from user_bets where bet_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); //prepareStatement() as opposed to create Statement()
			
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			ps.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our sql string
			
			rs = ps.executeQuery();
			
			//the next chunks of code are copied from earlier
			//create an empty lList to be filled
			List<UserBets> bets = new ArrayList<>();
			
			//we technically dont need this while loop since we're only getting one result back
			while(rs.next()) { //while there are results in the result set...
				
				//Use all args constructor to create a new User object from each returned row...
				UserBets b = new UserBets(
						//we want to use rs.xyz to get values from columns
						rs.getInt("bet_id"),
						rs.getInt("user_id_fk"),
						rs.getInt("game_id_fk"),
						rs.getString("bet_type"),
						rs.getString("description"),
						rs.getInt("amount")
						);
				 
				
				//and populate the ArrayList with each  bet
				bets.add(b); //b is the new bets object we created above
			}
			//when there are no more reulsts in the ResultSet the while loop will break
			//return the populated list of bets
			return bets;
			
		}catch (SQLException u) {
			System.out.println("Something went wrong with your database");
			u.printStackTrace();
		}
		
		
		return null;
	}
		
	
	//update a bet
	@Override
	public void updateBet(int id, int amount) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update user_bets set amount = ? where bet_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, amount);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			System.out.println("The amount for bet " + id + " has been changed to: $" + amount);
			
		} catch (SQLException e) {
			System.out.println("Bet update failed");
			e.printStackTrace();
		}

	}
		

	//cancel a bet
	@Override
	public void cancelBet(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from user_bets where bet_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,  id);
			ps.execute();
			
			System.out.println("The following bet was deleted: bet " + id);
			
		} catch (SQLException e) {
			System.out.println("Bet could not be deleted.");
			e.printStackTrace();
		}
		
		
	}

	
}
