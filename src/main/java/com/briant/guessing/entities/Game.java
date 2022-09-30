package com.briant.guessing.entities;

import java.util.Objects;

public class Game {
    
    private int GameID;
    private String Answer;
    private boolean Finished;

    public Game() {
    }

    public Game(String Answer, boolean Finished) {
        this.Answer = Answer;
        this.Finished = Finished;
    }
    
    

    public Game(int GameID, String Answer, boolean Finished) {
        this.GameID = GameID;
        this.Answer = Answer;
        this.Finished = Finished;
    }

    public int getGameID() {
        return GameID;
    }

    public void setGameID(int GameID) {
        this.GameID = GameID;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public boolean isFinished() {
        return Finished;
    }

    public void setFinished(boolean Finished) {
        this.Finished = Finished;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.GameID;
        hash = 47 * hash + Objects.hashCode(this.Answer);
        hash = 47 * hash + (this.Finished ? 1 : 0);
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
        final Game other = (Game) obj;
        if (this.GameID != other.GameID) {
            return false;
        }
        if (this.Finished != other.Finished) {
            return false;
        }
        if (!Objects.equals(this.Answer, other.Answer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "GameID=" + GameID + ", Answer=" + Answer + ", Finished=" + Finished + '}';
    }
   
}
