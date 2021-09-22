package com.revature.models;

public class Games {

	//fields for the Games class -- must match those in your database
	private int game_id;
	private String sport;
	private String date;
	private String teams;
	private String spread;
	private String over_under;
	
	
	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Games(int game_id, String sport, String date, String teams, String spread, String over_under) {
		super();
		this.game_id = game_id;
		this.sport = sport;
		this.date = date;
		this.teams = teams;
		this.spread = spread;
		this.over_under = over_under;
	}


	public Games(String sport, String date, String teams, String spread, String over_under) {
		super();
		this.sport = sport;
		this.date = date;
		this.teams = teams;
		this.spread = spread;
		this.over_under = over_under;
	}


	@Override
	public String toString() {
		return "Games [game_id=" + game_id + ", sport=" + sport + ", date=" + date + ", teams=" + teams + ", spread="
				+ spread + ", over_under=" + over_under + "]";
	}


	public int getGame_id() {
		return game_id;
	}


	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}


	public String getSport() {
		return sport;
	}


	public void setSport(String sport) {
		this.sport = sport;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTeams() {
		return teams;
	}


	public void setTeams(String teams) {
		this.teams = teams;
	}


	public String getSpread() {
		return spread;
	}


	public void setSpread(String spread) {
		this.spread = spread;
	}


	public String getOver_under() {
		return over_under;
	}


	public void setOver_under(String over_under) {
		this.over_under = over_under;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + game_id;
		result = prime * result + ((over_under == null) ? 0 : over_under.hashCode());
		result = prime * result + ((sport == null) ? 0 : sport.hashCode());
		result = prime * result + ((spread == null) ? 0 : spread.hashCode());
		result = prime * result + ((teams == null) ? 0 : teams.hashCode());
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
		Games other = (Games) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (game_id != other.game_id)
			return false;
		if (over_under == null) {
			if (other.over_under != null)
				return false;
		} else if (!over_under.equals(other.over_under))
			return false;
		if (sport == null) {
			if (other.sport != null)
				return false;
		} else if (!sport.equals(other.sport))
			return false;
		if (spread == null) {
			if (other.spread != null)
				return false;
		} else if (!spread.equals(other.spread))
			return false;
		if (teams == null) {
			if (other.teams != null)
				return false;
		} else if (!teams.equals(other.teams))
			return false;
		return true;
	}

	
	
	
	
}
