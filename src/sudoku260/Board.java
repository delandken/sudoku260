/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

/**
 *
 * @author Ken
 */
public class Board {
    private int[][] theBoard = new int[9][9];
    
    private boolean isValid = false;
    
    public void setValueAt(int row, int column, int value) {
        theBoard[row][column] = value;
    }
    
    public int getValueAt(int row, int column) {
        return theBoard[row][column];
    }
    
    public boolean getValid() {
        return isValid;
    }
}
