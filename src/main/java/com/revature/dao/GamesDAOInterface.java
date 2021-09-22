package com.revature.dao;

import java.util.List;

import com.revature.models.Games;

public interface GamesDAOInterface {
	
	public List<Games> getGames(); //returns a list of all games user can bet on
	
}
