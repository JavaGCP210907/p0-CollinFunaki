package com.revature.dao;

import java.util.List;

import com.revature.models.UserBets;

public interface UserBetsDAOInterface {
	
	public void placeBet(UserBets UserBet);
	
	public List<UserBets> getBets(int id);
	
	public void updateBet(int id, int amount);
	
	public void cancelBet(int id);
	
}

