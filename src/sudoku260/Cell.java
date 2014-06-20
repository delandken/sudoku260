/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This class represents a cell on the sudoku board. The cell contains a value.
 * In the future, this class will also belong to several CellGroups, which can be used
 * to help it determine valid values quickly.
 * 
 * @author Ken
 */
public class Cell {
    private int value = 0;
    private boolean fixed = true; //Assume it's fixed unless told otherwise.
    
    //This value should NOT be settable by the outside world.
    private ArrayList<CellGroup> groups = new ArrayList<CellGroup>();
    
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
    
    public boolean isFixed() {
        return fixed;
    }
    
    public void assignToGroup(CellGroup group) {
        groups.add(group);
        group.addCell(this);
    }
    
    public ArrayList<CellGroup> getGroups() {
        return groups;
    }
    
    public boolean isValueAllowed(int value) {
        for(CellGroup group : groups) {
            if(!group.isValueAllowed(value)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> getPossibleValues() {
        //Stub method, fill this in later;
        ArrayList<Integer> possibleValues = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++) 
            possibleValues.add(i);
        for(CellGroup group : groups) {
            possibleValues.retainAll(group.getPossibleValues());
        }
        
        return possibleValues;
    }
}
