/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Ken DeLand
 */
public class Player implements Serializable {
    
    private String nickname;
    private int numGames;
    private int numWins;
    private int numLosses;
    
    public Player(){}

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getNumGames() {
        return numGames;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public int getNumWins() {
        return numWins;
    }

    public void setNumWins(int numWins) {
        this.numWins = numWins;
    }

    public int getNumLosses() {
        return numLosses;
    }

    public void setNumLosses(int numLosses) {
        this.numLosses = numLosses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nickname);
        hash = 97 * hash + this.numGames;
        hash = 97 * hash + this.numWins;
        hash = 97 * hash + this.numLosses;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (this.numGames != other.numGames) {
            return false;
        }
        if (this.numWins != other.numWins) {
            return false;
        }
        if (this.numLosses != other.numLosses) {
            return false;
        }
        return true;
    }
}  

