/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.menu;

import edu.byui.teamawesome.sudoku260.Board;
import edu.byui.teamawesome.sudoku260.CoordinateWrapper;
import edu.byui.teamawesome.sudoku260.GetCellController;
import edu.byui.teamawesome.sudoku260.GetValueController;
import edu.byui.teamawesome.sudoku260.exceptions.MenuExceptions;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ken
 */
public class GameMenuView extends Menu {
    private Board theBoard;
    
    private static final GetCellController getCellController = new GetCellController();
    
    public GameMenuView() {
       theBoard = new Board();
       
      menuItems.put("S", new SetSquareHandler());
      menuItems.put("P", new PossibleValuesHandler());
      menuItems.put("O", new SolveHandler());
      menuItems.put("R", new RestartHandler());
      menuItems.put("H", new HelpHandler());
    }
    
    public void display() {
        System.err.println(theBoard.toString());
        System.out.println();
        super.display();
    }
    
    private final class SetSquareHandler implements MenuItemCommand{

        @Override
        public String getName() {
           return "Set Square";
        }

        @Override
        public void handleIt() {
           CoordinateWrapper coordinates = getCellController.promptForCoordinates();

            if(theBoard.canSetCell(coordinates)) {
                int value = GetValueController.promptForValue();
                theBoard.setValueAt(coordinates, value);
            }
        }
    
    }
    
    private final class PossibleValuesHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Possible Values";
        }

        @Override
        public void handleIt() {
            CoordinateWrapper coordinates = getCellController.promptForCoordinates();
            ArrayList<Integer> possibleValues = theBoard.getPossibleValuesAt(coordinates);
            for(Integer val : possibleValues) {
                System.out.print(val + " ");
            }
        }
        
    }
    
    private final class RestartHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Restart Handler";
        }

        @Override
        public void handleIt() {
            theBoard = new Board();
        }
        
    }
    
    private static final class HelpHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Help";
        }

        @Override
        public void handleIt() {
            HelpMenuView menu = new HelpMenuView();
            try {
                menu.getInput();
            } catch (MenuExceptions ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    private static final class SolveHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Solve";
        }

        @Override
        public void handleIt() {
            System.out.println("Coming soon!");
        }
    
    }
}
