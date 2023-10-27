CREATE TABLE tbl_user (
	id serial PRIMARY KEY,
	username VARCHAR ( 15 )  NOT NULL,
	owner VARCHAR ( 15 ) NOT NULL
);

INSERT INTO tbl_user (id, username, owner) VALUES
(1, 'Steve Jobs', 'Apple'),
(2, 'Lary Page', 'Google');