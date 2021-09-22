package com.revature.models;

public class Users {

	//fields for the employee class -- must match those in your database
		private int user_id;
		private String f_name;
		private String l_name;
		private int bets_won;
		private int bets_lossed;
		private int net;
		private int total_wagered;

		
		//boilerplate code below---------------- //alt+shift+s to generate menu for boilerplate code
		
		//no args constructor
		public Users() {
			//
		}

		//all args constructor
		public Users(int user_id, String f_name, String l_name, int bets_won, int bets_lossed, int net,
				int total_wagered) {
			super();
			this.user_id = user_id;
			this.f_name = f_name;
			this.l_name = l_name;
			this.bets_won = bets_won;
			this.bets_lossed = bets_lossed;
			this.net = net;
			this.total_wagered = total_wagered;
		}

		
		//all args except auto increment primary key
		public Users(String f_name, String l_name, int bets_won, int bets_lossed, int net, int total_wagered) {
			super();
			this.f_name = f_name;
			this.l_name = l_name;
			this.bets_won = bets_won;
			this.bets_lossed = bets_lossed;
			this.net = net;
			this.total_wagered = total_wagered;
		}

		//toString 
		@Override
		public String toString() {
			return "Users [user_id=" + user_id + ", f_name=" + f_name + ", l_name=" + l_name + ", bets_won=" + bets_won
					+ ", bets_lossed=" + bets_lossed + ", net=" + net + ", total_wagered=" + total_wagered + "]";
		}

		//getter and setter
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getF_name() {
			return f_name;
		}

		public void setF_name(String f_name) {
			this.f_name = f_name;
		}

		public String getL_name() {
			return l_name;
		}

		public void setL_name(String l_name) {
			this.l_name = l_name;
		}

		public int getBets_won() {
			return bets_won;
		}

		public void setBets_won(int bets_won) {
			this.bets_won = bets_won;
		}

		public int getBets_lossed() {
			return bets_lossed;
		}

		public void setBets_lossed(int bets_lossed) {
			this.bets_lossed = bets_lossed;
		}

		public int getNet() {
			return net;
		}

		public void setNet(int net) {
			this.net = net;
		}

		public int getTotal_wagered() {
			return total_wagered;
		}

		public void setTotal_wagered(int total_wagered) {
			this.total_wagered = total_wagered;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bets_lossed;
			result = prime * result + bets_won;
			result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
			result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
			result = prime * result + net;
			result = prime * result + total_wagered;
			result = prime * result + user_id;
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
			Users other = (Users) obj;
			if (bets_lossed != other.bets_lossed)
				return false;
			if (bets_won != other.bets_won)
				return false;
			if (f_name == null) {
				if (other.f_name != null)
					return false;
			} else if (!f_name.equals(other.f_name))
				return false;
			if (l_name == null) {
				if (other.l_name != null)
					return false;
			} else if (!l_name.equals(other.l_name))
				return false;
			if (net != other.net)
				return false;
			if (total_wagered != other.total_wagered)
				return false;
			if (user_id != other.user_id)
				return false;
			return true;
		}
		
		
		
}
