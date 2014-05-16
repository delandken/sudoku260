/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.ArrayList;

/**
 * This class represents a cell on the sudoku board. The cell contains a value.
 * In the future, this class will also belong to several CellGroups, which can be used
 * to help it determine valid values quickly.
 * 
 * @author Ken
 */
public class Cell {
    private int value = 0;
    private ArrayList<CellGroup> groups = new ArrayList<CellGroup>();
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void assignToGroup(CellGroup group) {
        groups.add(group);
        group.addCell(this);
    }
    
    public boolean isValueAllowed(int value) {
        for(CellGroup group : groups) {
            if(!group.isValueAllowed(value)) {
                return false;
            }
        }
        return true;
    }
}
