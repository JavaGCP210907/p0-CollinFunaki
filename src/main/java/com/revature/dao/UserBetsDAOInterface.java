package com.revature.dao;

import com.revature.models.UserBets;

public interface UserBetsDAOInterface {
	
	public void placeBet(UserBets UserBet);
	
}

//bet_id serial PRIMARY KEY,
//user_id_fk int REFERENCES users (user_id),
//game_id_fk int REFERENCES games (game_id),
//bet_type text,
//description text,
//amount int