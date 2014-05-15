/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.ArrayList;

/**
 * This class represents an exclusive group of cells. Meaning, either a row of 9,
 * or a column of 9, or a "sub-square" of 9. This class will then monitor the values
 * that are still legal in it.
 * 
 * This means, that when a cell changes values, it only needs to ask the groups it is
 * part of if the value is allowed. If it is allowed in all groups, then the value
 * is valid.
 * 
 * For now, we just maintain a table of allowable values (sort of like a hash map)
 * but in the future it might be better to check it each time a new value is being added.
 * 
 * @author Ken
 */
public class CellGroup {
    private boolean valid = true;
    
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private boolean[] allowableValues = {true,true,true,true,true,true,true,true,true};
    
    public boolean isValid() {
        return valid;
    }
    
    public void addCell(Cell cell) {
        cells.add(cell);
        //If this cell has a value, then mark that it is no longer an allowable value:
        if(cell.getValue() != 0) {
            allowableValues[cell.getValue() - 1] = false;
        }
    }
    
    public boolean isValueAllowed(int value) {
        if (value > 9 || value < 1) {
            System.out.println ("Number must be 1-9");
                 return false;            
        } 
      for (int i = 0; i < cells.size(); i++ ) {
          if (cells.get(i).getValue() == value) {
              return false; 
          } 
      } 
      return true; 
    }
}
