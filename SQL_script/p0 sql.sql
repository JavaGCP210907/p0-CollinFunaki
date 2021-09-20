--DDL for p0

--create the necessary tables
CREATE TABLE users ( 
	user_id serial PRIMARY KEY,
	bets_won int,
	bets_lossed int,
	net double,
	total_wagered double
	
);

CREATE TABLE games (
	game_id serial PRIMARY KEY,
	sport text,
	date text, 
	teams text,
	spread text,
	over_under text,
	house_net double,
	bets_placed int

);

CREATE TABLE user_bets (
	bet_id PRIMARY KEY,
	user_id_fk REFERENCES users (user_id),
	game_id_fk REFERENCES games (game_id),
	bet_type_id_fk
	amount double
);

CREATE TABLE bet_types (
	bet_type int PRIMARY KEY,
	description text,
);





