package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Games;
import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class GamesDAO implements GamesDAOInterface{

	@Override
	public List<Games> getGames() {
		
		//get the games table from the database
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from games";
			
			PreparedStatement ps = conn.prepareStatement(sql); //prepareStatement() as opposed to create Statement()
			
			
			rs = ps.executeQuery();
			
			//the next chunks of code are copied from earlier
			//create an empty List to be filled
			List<Games> gameList = new ArrayList<>();
			
			//we technically dont need this while loop since we're only getting one result back
			while(rs.next()) { //while there are results in the result set...
				
				//Use all args constructor to create a new User object from each returned row...
				Games g = new Games(
						//we want to use rs.xyz to get values from columns
						rs.getInt("game_id"),
						rs.getString("sport"),
						rs.getString("date"),
						rs.getString("teams"),
						rs.getString("spread"),
						rs.getString("over_under")
						);
				 
				
				//and populate the ArrayList with each new game
			gameList.add(g); //e is the new employee object we created above
			}
			//when there are no more reulsts in the ResultSet the while loop will break
			//return the populated list of employees
			return gameList;
			
		}catch (SQLException u) {
			System.out.println("Something went wrong with your database");
			u.printStackTrace();
		}
		
		
		return null;
		
	}
	
}
