--DDL for p0

--create the necessary tables
CREATE TABLE users ( 
	user_id serial PRIMARY KEY,
	f_name text,
	l_name text,
	bets_placed int,
	net int,
	total_wagered int
	
);

CREATE TABLE games (
	game_id serial PRIMARY KEY,
	sport text,
	date text, 
	teams text,
	spread text,
	over_under text

);

CREATE TABLE user_bets (
	bet_id serial PRIMARY KEY,
	user_id_fk int REFERENCES users (user_id),
	game_id_fk int REFERENCES games (game_id),
	bet_type text,
	description text,
	amount int
);


--CREATE TABLE bet_types (
--	bet_type int PRIMARY KEY,
--	description text,
--);

DROP TABLE user_bets;
DROP TABLE games;
DROP TABLE users;


--add data to tables
INSERT INTO users (f_name, l_name, bets_placed, net, total_wagered)
VALUES ('William', 'Gates', 54, -1090250, 2900000),
		('Bezos', 'Jeffrey', 23, -200000, 1000000),
		('Warren', 'Buffet', 990, 102000, 4030400),
		('Elon', 'Musk', 1032, 4020000, 9030453);
	
--add data to games table
INSERT INTO games (sport, date, teams, spread, over_under)
VALUES ('Basketball', '11/19/2021', 'Lakers vs Celtics', 'Lakers -5.5', '219.5'),
		('Baseball', '10/04/2021', 'Yankees vs Dodgers', 'Dodgers -1.5', '8.5'),
		('Football', '10/01/2021', 'Packers vs Cowboys', 'Packers -2.5', '48.5'),
		('Hockey','12/03/2021', 'Bruins vs Capitals', 'Bruins -0.5', '4.5'),
		('Soccer', '11/10/2021', 'PSG vs Manchester United', 'PSG -0.5', '2.5');
	
--add data to user_bets table
INSERT INTO user_bets (user_id_fk, game_id_fk, bet_type, description, amount)
	VALUES (1, 3, 'Spread', 'Packers -2.5', 1000),
			 (3, 1, 'Over/Under', 'Over 219.5', 500),
			 (2, 5, 'Spread', 'Manchester United +0.5', 90000),
			 (4, 5, 'Over/Under', 'Over 8.5', 100000);
	
	

