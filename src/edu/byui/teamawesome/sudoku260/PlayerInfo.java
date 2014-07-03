/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260;

import java.io.Serializable;

/**
 *
 * @author AshleyFaust
 */
public class PlayerInfo implements Serializable{
    private int HighScore;
    private int NickName;
   
    public int getHighScore() {
        return HighScore;
    }    
    public void setHighScore(int HighScore) {
        this.HighScore = HighScore;
    }
    
    public int getNickName() {
        return NickName;
    }

    public void setNickName(int NickName) {
        this.NickName = NickName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.HighScore;
        hash = 47 * hash + this.NickName;
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
        final PlayerInfo other = (PlayerInfo) obj;
        if (this.HighScore != other.HighScore) {
            return false;
        }
        if (this.NickName != other.NickName) {
            return false;
        }
        return true;
    }


}

