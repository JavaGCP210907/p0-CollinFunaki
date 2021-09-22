--DDL for p0

--create the necessary tables
CREATE TABLE users ( 
	user_id serial PRIMARY KEY,
	fname TEXT,
	lname TEXT,
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
--	house_net double,
--	num_bets_on_game int

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

--DROP TABLE users;
--DROP TABLE games;
--DROP TABLE user_bets;

--add data to tables
INSERT INTO users (fname, lname, bets_placed, net, total_wagered)
VALUES ('Bill', 'Gates', 54, -1090250, 2900000),
		('Bezos', 'Jeffrey', 23, -200000, 1000000);
