/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.values;

/**
 *
 * @author ken
 */
public class NumericValues implements SudokuValue {

    @Override
    public String getValueAtOrdinal(int value) {
        return "" + value;
    }

    @Override
    public boolean isValidValue(String val) {
        try {
            //Parse it:
            int numVal = Integer.parseInt(val);
            return numVal > 0 && numVal < 9;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }

    @Override
    public int getOrdinalForValue(String val) {
        try { 
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
}
