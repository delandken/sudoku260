/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.teamawesome.sudoku260.values;

/**
 *
 * @author ken
 */
public class AlphaValues implements SudokuValue {
    private enum values {
        B,
        Y,
        U,
        DASH {
            public String toString() {
                return "-";
            }
        },
        I,
        D,
        A,
        H,
        O
    };
    
    public String getValueAtOrdinal(int value) {
        if (value < 0) {
            return " ";
        }
        return values.values()[value].toString();
    }
    
    public boolean isValidValue(String val) {
        if(val.equals("-")) {
            val = "DASH";
        }
        try {
            values.valueOf(val);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}