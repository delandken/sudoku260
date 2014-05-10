/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

/**
 * This class represents a cell on the sudoku board. The cell contains a value.
 * In the future, this class will also belong to several CellGroups, which can be used
 * to help it determine valid values quickly.
 * 
 * @author Ken
 */
public class Cell {
    private int value = 0;
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
}
