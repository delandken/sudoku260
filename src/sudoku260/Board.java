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
    //This attribute represents the cells that make up our grid.
    private Cell[] theBoard = new Cell[81];
    //This attribute represents the rows in our grid.
    private CellGroup[] rows = new CellGroup[9];
    //This attribute represents the columns in our grid.
    private CellGroup[] columns = new CellGroup[9];
    //This attribute represents the 3x3 subsquares in our grid.
    private CellGroup[] subsquares = new CellGroup[9];
    
    //This attribute represents (and will represent) the difficulty of this grid.
    private String difficulty = "Medium";
    
    //This method is used by the board generation process to count how many solutions our board has.
    private int possibleSolutions;
    
    //Our default constructor.
    public Board() {
        theBoard = generateBoard(theBoard, 0);
        drillBoard();
    }
    
    //A private method which will generate a fully solved board. This is a recursive method.
    private Cell[] generateBoard(Cell[] theBoard, int index) {
        
        //Sanity Check, index cannot be less than 0
        //Conditional statements.
        //Character escape sequences:
        if(index < 0 || index > 80) {
            System.out.println("Invalid index of \"" + index + "\". Index must be greater than 0 and less than 80");
            return null;
        }
        
        //Determine our row, and column:
        //Two mathematical operators: /, and %
        //Casting to int, to force integer division (for learning purposes).
        //Two primitives:
        int row = (int)(index / 9);
        int column = index % 9;
        
        int subSquareRow = row / 3;
        int subSquareColumn = column / 3;
        
        int subSquareIndex = (subSquareRow * 3) + subSquareColumn;
        
        
        //We need to make a new cell for this space:
        theBoard[index] = new Cell();
        
        //Make sure there is a row, and column:
        if(rows[row] == null) {
            rows[row] = new CellGroup();
        }
        //Assign the cell to this row.
        theBoard[index].assignToGroup(rows[row]);
        
        if(columns[column] == null) {
            columns[column] = new CellGroup();
        }
        //Assign the cell to this column.
        theBoard[index].assignToGroup(columns[column]);
        
        //Make sure there is a sub square:
        if(subsquares[subSquareIndex] == null) {
            subsquares[subSquareIndex] = new CellGroup();
        }
        
        //Assign the cell to this column:
        theBoard[index].assignToGroup(subsquares[subSquareIndex]);
        
        //Generate the list of all possible values:
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        
        //Shuffle or randomize the list, so that we can make sure the puzzle generated
        //is different every time.
        Collections.shuffle(numbers);
        
        //Loop through every possible number...
        while(numbers.size() > 0) {
            
            //Take our first possibility.
            int number = numbers.remove(0);

            //Find out if this value is allowed for this cell:
            if(theBoard[index].isValueAllowed(number)) {
                //Set the value to our number.
                theBoard[index].setValue(number);
                
                //If we are at the last index (81) than we are finished, if not
                //test the next index.
                if(index + 1 < 81) {
                    //Generate a new board (that so that we can test possibilities)
                    Cell[] tmpBoard = generateBoard(theBoard, index + 1);
                    
                    //If it did not return null, then we have a complete board.
                    if(tmpBoard != null) {
                        return tmpBoard;
                    }
                } else {
                    //We've reached the end, return the board.
                    return theBoard;
                }
                
                //If it did return null, this configuration is invalid
                //so set our value back to 0 (which means unset), and try the next value.
                theBoard[index].setValue(0);
            }
        }
        //If we reach this point, than our board is unsolvable.
//        System.out.println("Warning: The board is unsolvable.");
        return null;
    }
    
    //This method will randomly remove slots from the board.
    private void drillBoard() {
        //Start with a list of possible position:
        List<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i < 81; i++) {
            positions.add(i);
        }
        Collections.shuffle(positions);
        
        while(positions.size() > 0) {
            int position = positions.remove(0);
            int temp = theBoard[position].getValue();
            theBoard[position].setValue(0);
            theBoard[position].setFixed(false);
            possibleSolutions = 0;
            if(!isValid(0)) {
                theBoard[position].setValue(temp);
                theBoard[position].setFixed(true);
            }
        }   
    }
    
    //This method will test that the current board has one, and only one solution.
    private boolean isValid(int index) {
        if(theBoard == null || index < 0) {
            return false;
        }
        if(index > 80) {
            return ++possibleSolutions == 1;
        }
        
        //Find out if the current cell has a zero value:
        if(theBoard[index].getValue() == 0) {
            ArrayList<Integer> possibleValues = theBoard[index].getPossibleValues();
            for(Integer value : possibleValues) {
                theBoard[index].setValue(value);
                
                if(!isValid(index + 1)) {
                    theBoard[index].setValue(0);
                    return false;
                }
                theBoard[index].setValue(0);
            }
            
        } else if(!isValid(index + 1)) {
            return false;
        }
        
        return true;
    }
    
    
    //This method is a public facing API, it allows a system to specify a row, column, and value
    //And it will update that value.
    public void setValueAt(int row, int column, int value) {
        Cell square = theBoard[(row * 9 + column)];
        if(square != null) {
            square.setValue(value);
        } else {
          square = new Cell();
          square.setValue(value);
          theBoard[(row * 9 + column)] = square;
        }
    }
    
    //This method will get the value of a certain square.
    public int getValueAt(int row, int column) {
        Cell square = theBoard[(row * 9 + column)];
        if(square != null)
            return square.getValue();
        else
            return 0;
    }
    
    //This method needs to be refactored :(
    public Cell at(int row, int column) {
        return theBoard[((column - 1) * 9) + (row - 1)];
    }
    
    //Getter / setter methods.
    public String getDifficulty() {
        return difficulty;
    }
    
    //This method helps to print our board to the terminal.
    public String toString() {
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i < theBoard.length; i++) {
            if(i % 9 == 0) {
                if(i != 0)
                    sb.append('|');
                sb.append('\n');
                
                if((i/9) % 3 == 0) {
                    sb.append("======================\n");
                }
            }
            if(i % 3 == 0)
              sb.append("|");
            
            sb.append(theBoard[i].getValue() + " ");
      }
      sb.append("|\n======================\n");
      
      return sb.toString();
    };
    
    /**
    * This class represents a cell on the sudoku board. The cell contains a value.
    * In the future, this class will also belong to several CellGroups, which can be used
    * to help it determine valid values quickly.
    * 
    * This class is an inner class, because of its relationship with the SudokuBoard. Nothing outside of the board
    * needs to be aware of these cells.
    * @author Ken
    */
   private class Cell {
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
   
   
   /**
    * This class represents an exclusive group of cells. Meaning, either a row of 9,
    * or a column of 9, or a "sub-square" of 9. This class will then monitor the values
    * that are still legal in it.
    * 
    * This means, that when a cell changes values, it only needs to ask the groups it is
    * part of if the value is allowed. If it is allowed in all groups, then the value
    * is valid.
    * 
    * This class exists here, because of it's relationship with the Board.
    * 
    * @author Ken
    */
   public class CellGroup {
       private boolean valid = true;

       //This should not be gettable, since we perform some logic when adding cells.
       private ArrayList<Cell> cells = new ArrayList<Cell>();


       public boolean isValid() {
           return valid;
       }

       public void setValid(boolean valid) {
           this.valid = valid;
       }

       public void addCell(Cell cell) {
           cells.add(cell);
       }

       public ArrayList<Cell> getCells() {
           return cells;
       }

       public boolean isValueAllowed(int value) {
           if(value == 0) {
               return false;
           }
           //Int value is our first primitive variable type.
           // We used the <, >, and || operators
           if (value > 9 || value < 1) {
               //We have escaped the ", twice.
               System.out.println ("\"" + value + "\" is invalid. Number must be 1-9");
                    return false;            
           } 

           //For learning purposes, we are going to cast the int to a double for checking.
           double cellValue;

           boolean isValid = true;
           //int i, our counter variable is our second variable type.
           //We used the ++ mathematical operator.
           //We used the < operator.
           for (int i = 0; i < cells.size(); i++ ) {
               //We used the == operator.
               //Casting to a double, for learning purposes
               cellValue = (double) cells.get(i).getValue();

               //Casting again for learning purposes
               if (cellValue == (double)value) {
                   isValid = false;
                   break;
               } 
           } 
         return isValid;
       }

       public ArrayList<Integer> getPossibleValues() {
           ArrayList<Integer> possibleValues = new ArrayList<Integer>();
           if(cells == null) {
               return possibleValues;
           }

           boolean[] values = new boolean[9];
           for(Cell cell: cells) {
               if(cell.getValue() < 10 && cell.getValue() > 0){
                   values[cell.getValue() - 1] = true;
               }
           }

           for(int i = 0; i < values.length; i++) {
               if(values[i] == false) {
                   possibleValues.add(i + 1);
               }
           }

           return possibleValues;
       }
   }

}
