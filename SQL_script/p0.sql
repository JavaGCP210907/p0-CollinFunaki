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
		('Elon', 'Musk', 1032, 4020000, 9030453),
		('Mark', 'Zuckerberg', 12, -43202, 10453),
		('Bernard', 'Arnault', 19023, -9220000, 20304853);
	
--add data to games table
INSERT INTO games (sport, date, teams, spread, over_under)
VALUES ('Basketball', '11/19/2021', 'Lakers vs Celtics', 'Lakers -5.5', '219.5'),
		('Basketball', '11/12/2021', 'Wizards vs Bulls', 'Wizards -2.5', '234.5'),
		('Baseball', '10/04/2021', 'Yankees vs Dodgers', 'Dodgers -1.5', '8.5'),
		('Baseball', '10/06/2021', 'Red Sox vs Cubs', 'Red Sox -2.5', '6.5'),
		('Football', '10/01/2021', 'Packers vs Cowboys', 'Packers -2.5', '50.5'),
		('Football', '10/08/2021', 'Steelers vs WFT', 'Steelers -6.5', '48.5'),
		('Hockey','12/03/2021', 'Bruins vs Capitals', 'Bruins -0.5', '4.5'),
		('Hockey','12/10/2021', 'Rangers vs Blackhawks', 'Blackhawks -1.5', '5.5'),
		('Soccer', '11/10/2021', 'PSG vs Manchester United', 'PSG -0.5', '2.5'),
		('Soccer', '11/17/2021', 'Chelsea vs Barcelona', 'Chelsea -0.5', '3.5');
	
--add data to user_bets table
INSERT INTO user_bets (user_id_fk, game_id_fk, bet_type, description, amount)
	VALUES (1, 3, 'Spread', 'Packers -2.5', 1000),
			 (3, 1, 'Over/Under', 'Over 219.5', 500),
			 (2, 9, 'Spread', 'Manchester United +0.5', 90000),
			 (4, 2, 'Over/Under', 'Wizards -2.5', 8000),
			 (5, 4, 'Spread', 'Red Sox -2.5', 400),
			 (6, 6, 'Over/Under', 'Under 48.5', 2000),
			 (1, 10, 'Spread', 'Barcelona -0.5', 49500),
			 (1, 8, 'Spread', 'Blackhawks -1.5', 250000),
			 (2, 2, 'Over/Under', 'Over 234.5', 5000),
			 (2, 7, 'Spread', 'Bruins -0.5', 2000),
			 (3, 5, 'Over/Under', 'Over 50.5', 10000000);
	
