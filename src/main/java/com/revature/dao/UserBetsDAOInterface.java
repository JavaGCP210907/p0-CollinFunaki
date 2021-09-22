package com.revature.dao;

public interface UserBetsDAOInterface {
	
	public void placeBet(int userId, int game_id, int betType, int amount);
	
}

//bet_id serial PRIMARY KEY,
//user_id_fk int REFERENCES users (user_id),
//game_id_fk int REFERENCES games (game_id),
//bet_type text,
//description text,
//amount int