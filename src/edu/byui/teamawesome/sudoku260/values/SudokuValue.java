/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.teamawesome.sudoku260.values;

/**
 *
 * @author ken
 */
public interface SudokuValue {
    
    public String getValueAtOrdinal(int value);
    public boolean isValidValue(String val);
}
