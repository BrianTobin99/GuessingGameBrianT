DROP DATABASE IF EXISTS GuessTheNumberDB;
CREATE DATABASE GuessTheNumberDB;
USE GuessTheNumberDB;

CREATE TABLE Game (
	GameID INT PRIMARY KEY AUTO_INCREMENT,
    Answer char(4),
    Finished BOOLEAN DEFAULT false
);

CREATE TABLE Round (
	RoundID INT PRIMARY KEY AUTO_INCREMENT,
    GameID INT NOT NULL,
    GuessTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Guess CHAR(4),
    Result CHAR(7),
    FOREIGN KEY Round (GameID) REFERENCES Game(GameID)
);
    
select * from Game;
select * from Round;
    