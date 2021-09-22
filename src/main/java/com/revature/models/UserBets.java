package com.revature.models;

public class UserBets {
	
	//add varaibles from user_bets table
	private int user_id_fk;
	private int game_id_fk;
	private String bet_type;
	private String description;
	private int amount;
	
	//add boilerplate code
	
	public UserBets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBets(int user_id_fk, int game_id_fk, String bet_type, String description, int amount) {
		super();
		this.user_id_fk = user_id_fk;
		this.game_id_fk = game_id_fk;
		this.bet_type = bet_type;
		this.description = description;
		this.amount = amount;
	}

	public UserBets(int game_id_fk, String bet_type, String description, int amount) {
		super();
		this.game_id_fk = game_id_fk;
		this.bet_type = bet_type;
		this.description = description;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UserBets [user_id_fk=" + user_id_fk + ", game_id_fk=" + game_id_fk + ", bet_type=" + bet_type
				+ ", description=" + description + ", amount=" + amount + "]";
	}

	public int getUser_id_fk() {
		return user_id_fk;
	}

	public void setUser_id_fk(int user_id_fk) {
		this.user_id_fk = user_id_fk;
	}

	public int getGame_id_fk() {
		return game_id_fk;
	}

	public void setGame_id_fk(int game_id_fk) {
		this.game_id_fk = game_id_fk;
	}

	public String getBet_type() {
		return bet_type;
	}

	public void setBet_type(String bet_type) {
		this.bet_type = bet_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((bet_type == null) ? 0 : bet_type.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + game_id_fk;
		result = prime * result + user_id_fk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBets other = (UserBets) obj;
		if (amount != other.amount)
			return false;
		if (bet_type == null) {
			if (other.bet_type != null)
				return false;
		} else if (!bet_type.equals(other.bet_type))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (game_id_fk != other.game_id_fk)
			return false;
		if (user_id_fk != other.user_id_fk)
			return false;
		return true;
	}
	
	
}
