package com.briant.guessing.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Round {
    private int RoundID;
    private int GameID;
    private LocalDateTime GuessTime;
    private String Guess;
    private String Result;

    public Round() {
    }

    public Round(int GameID, String Guess) {
        this.GameID = GameID;
        this.Guess = Guess;
    }
    

    public Round(int RoundID, int GameID, LocalDateTime GuessTime, String guess, String Result) {
        this.RoundID = RoundID;
        this.GameID = GameID;
        this.GuessTime = GuessTime;
        this.Guess = guess;
        this.Result = Result;
    }

    public int getRoundID() {
        return RoundID;
    }

    public void setRoundID(int RoundID) {
        this.RoundID = RoundID;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int GameID) {
        this.GameID = GameID;
    }

    public LocalDateTime getGuessTime() {
        return GuessTime;
    }

    public void setGuessTime(LocalDateTime GuessTime) {
        this.GuessTime = GuessTime;
    }

    public String getGuess() {
        return Guess;
    }

    public void setGuess(String guess) {
        this.Guess = guess;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.RoundID;
        hash = 43 * hash + this.GameID;
        hash = 43 * hash + Objects.hashCode(this.GuessTime);
        hash = 43 * hash + Objects.hashCode(this.Guess);
        hash = 43 * hash + Objects.hashCode(this.Result);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.RoundID != other.RoundID) {
            return false;
        }
        if (this.GameID != other.GameID) {
            return false;
        }
        if (!Objects.equals(this.Guess, other.Guess)) {
            return false;
        }
        if (!Objects.equals(this.Result, other.Result)) {
            return false;
        }
        if (!Objects.equals(this.GuessTime, other.GuessTime)) {
            return false;
        }
        return true;
    }
    
    
}
