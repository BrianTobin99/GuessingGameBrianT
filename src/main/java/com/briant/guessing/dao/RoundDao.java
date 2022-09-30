package com.briant.guessing.dao;

import java.util.List;

import com.briant.guessing.entities.Round;


public interface RoundDao {
    
    List<Round> getAllRoundsByGameID(int GameID);
    Round getRoundByID(int RoundID);
    Round addRound(Round round);
}
