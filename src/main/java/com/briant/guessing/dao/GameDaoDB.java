package com.briant.guessing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.briant.guessing.entities.Game;

@Repository
public class GameDaoDB implements GameDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_GAMES = "SELECT * FROM Game";
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game getGameByID(int GameID) {
        try {
            final String SELECT_GAME_BY_ID = "SELECT * FROM Game WHERE GameID = ?";
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), GameID);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Game addGame(Game game) {
        final String INSERT_GAME = "INSERT INTO Game(answer) VALUES (?)";
        jdbc.update(INSERT_GAME, game.getAnswer());
        
        int newGameId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameID(newGameId);
        return game;
    }
    
    @Override
    public void updateGame(Game game) {
        final String UPDATE_GAME = "UPDATE Game SET Finished = ? WHERE GameID = ?";
        jdbc.update(UPDATE_GAME, game.isFinished(), game.getGameID());
    }
    
    public static final class GameMapper implements RowMapper<Game> {
        
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameID(rs.getInt("GameID"));
            game.setAnswer(rs.getString("answer"));
            game.setFinished(rs.getBoolean("Finished"));
            return game;
        }
    }
    
}
