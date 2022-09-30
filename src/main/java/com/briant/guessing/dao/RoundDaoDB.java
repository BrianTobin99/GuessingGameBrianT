package com.briant.guessing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.briant.guessing.entities.Round;

@Repository
public class RoundDaoDB implements RoundDao {

    @Autowired
    JdbcTemplate jdbc;
    
    @Override
    public List<Round> getAllRoundsByGameID(int GameID) {
        try {
        final String SELECT_ROUNDS_BY_GameID = "SELECT * FROM Round "
                + "WHERE GameID = ? ORDER BY GuessTime";
        List<Round> rounds = jdbc.query(SELECT_ROUNDS_BY_GameID, new RoundMapper(), GameID);
        return rounds;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Round getRoundByID(int RoundID) {
        try {
            final String SELECT_ROUND_BY_ID = "SELECT * FROM Round WHERE RoundID = ?";
            return jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), RoundID);
        } catch(DataAccessException ex) {
            return null;
        }    
    }

    @Override
    @Transactional
    public Round addRound(Round round) {
        final String INSERT_ROUND = "INSERT INTO Round(GameID, Guess, Result) VALUES(?,?,?)";
        jdbc.update(INSERT_ROUND, round.getGameID(), round.getGuess(), round.getResult());
        
        int newRoundID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundID(newRoundID);
        return getRoundByID(newRoundID);
    }
    
    
    public static final class RoundMapper implements RowMapper<Round> {
        
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundID(rs.getInt("RoundID"));
            round.setGameID(rs.getInt("GameID"));
            round.setGuess(rs.getString("Guess"));
            
            Timestamp timestamp = rs.getTimestamp("GuessTime");
            round.setGuessTime(timestamp.toLocalDateTime());
            
            round.setResult(rs.getString("Result"));
            return round;
        }
    }
   
}
