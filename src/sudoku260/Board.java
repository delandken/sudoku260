/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The main game board class. This class contains a multi-dimensional array of cells
 * which represents the grid being used for the game. It also knows if it is valid/solved,
 * and the difficulty of the board.
 * 
 * @TODO: Randomly generate the board and implement the difficulty settings.
 * 
 * @author Ken
 */
public class Board {
    private Cell[][] theBoard = new Cell[9][9];
    
    private boolean isValid = false;
    
    private String difficulty = "Medium";
    
    public void setValueAt(int row, int column, int value) {
        Cell square = theBoard[row][column];
        if(square != null) {
            square.setValue(value);
        } else {
          square = new Cell();
          square.setValue(value);
          theBoard[row][column] = square;
        }
    }
    
    public int getValueAt(int row, int column) {
        Cell square = theBoard[row][column];
        if(square != null)
            return square.getValue();
        else
            return 0;
    }
    
    public boolean getValid() {
        return isValid;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
}
