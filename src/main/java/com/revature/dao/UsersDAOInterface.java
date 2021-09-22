package com.revature.dao;

import java.util.List;

import com.revature.models.Users;


public interface UsersDAOInterface {
	
	
	public List<Users> getAccount(int id);//returns a list of user account info from Users table (select ?)
	
	public void deposit(int id); //add (update) money to user balance in users table
	
	public void withdraw(int id); //subtract (update) money to user balance
	
	
	
}
