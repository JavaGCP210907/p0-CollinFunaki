package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.UserBets;
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
	
}
