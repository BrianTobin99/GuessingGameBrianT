package com.briant.guessing.dao;

import java.util.List;

import com.briant.guessing.entities.Game;


public interface GameDao {
    List<Game> getAllGames();
    Game getGameByID(int GameID);
    Game addGame(Game game);
    void updateGame(Game round);
}
