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
//    private Cell[][] theBoard = new Cell[9][9];
    private Cell[] theBoard = new Cell[81];
    private CellGroup[] rows = new CellGroup[9];
    private CellGroup[] columns = new CellGroup[9];
    private CellGroup[] subsquares = new CellGroup[9];
    
    private boolean isValid = false;
    
    private String difficulty = "Medium";
    
    private int possibleSolutions;
    
    public Board() {
        theBoard = generateBoard(theBoard, 0);
        drillBoard();
    }
    
    
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
    
    public void drillBoard() {
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
            
            possibleSolutions = 0;
            if(!isValid(0)) {
                theBoard[position].setValue(temp);
            }
        }   
    }
    
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
    
    public int getValueAt(int row, int column) {
        Cell square = theBoard[(row * 9 + column)];
        if(square != null)
            return square.getValue();
        else
            return 0;
    }
    
    public Cell at(int row, int column) {
        return theBoard[((row - 1) * 9) + (column - 1)];
    }
    
    public boolean getValid() {
        return isValid;
    }
    
    public String getDifficulty() {
        return difficulty;
    }
    
    public String toString() {
      StringBuilder sb = new StringBuilder();
      
      for(int i = 0; i < theBoard.length; i++) {
          if(i % 9 == 0) {
                sb.append('\n');
            }
            sb.append(theBoard[i].getValue() + " ");
      }
      
 
      
      return sb.toString();
    };
}
