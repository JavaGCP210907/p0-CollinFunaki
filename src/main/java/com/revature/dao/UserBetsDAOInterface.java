package com.revature.dao;

import java.util.List;

import com.revature.models.UserBets;

public interface UserBetsDAOInterface {
	
	public void placeBet(UserBets UserBet);
	
	public List<UserBets> getBets(int id);
	
	public void cancelBet(int id);
	
}

