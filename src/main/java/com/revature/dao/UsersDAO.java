package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Users;
import com.revature.utils.ConnectionUtil;

public class UsersDAO {
	
	public List<Users> getAccount(int id) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from users where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); //prepareStatement() as opposed to create Statement()
			
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			ps.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our sql string
			
			rs = ps.executeQuery();
			
			//the next chunks of code are copied from earlier
			//create an empty lList to be filled
			List<Users> userList = new ArrayList<>();
			
			//we technically dont need this while loop since we're only getting one result back
			while(rs.next()) { //while there are results in the result set...
				
				//Use all args constructor to create a new User object from each returned row...
				Users u = new Users(
						//we want to use rs.xyz to get values from columns
						rs.getInt("user_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getInt("bets_won "),
						rs.getInt("bets_lossed"),
						rs.getInt("net"),
						rs.getInt("total_wagered")
						);
				 
				
				//and populate the ArrayList with each new Employee
				userList.add(u); //e is the new employee object we created above
			}
			//when there are no more reulsts in the ResultSet the while loop will break
			//return the populated list of employees
			return userList;
			
		}catch (SQLException u) {
			System.out.println("Something went wrong with your database");
			u.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	public void deposit(int id) {
		
		
		
	}
	
	
	
	public void withdraw(int id) { //subtract (update) money to user balance
		
	}



	
	
}
