/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.Scanner;

/**
 *
 * @author Ken
 */
public class GameMenuView {
    private final static String[][] menuItems = {
        {"S", "Set Square"},
        {"P", "Possible Values"},
        {"R", "Restart"},
        {"H", "Help"},
        {"O", "Solve"},
        {"Q", "Quit"}
    };
    
    private GameMenuController gameMenuController = new GameMenuController();
    private Board theBoard;
    
    public GameMenuView(Board theBoard) {
        this.theBoard = theBoard;
        gameMenuController.setBoard(theBoard);
    }
    
    public void getInput() {
        String command;
        Scanner inFile = Sudoku260.input;
        
        do {
            this.display();
            
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch(command) {
                case "S":
                    gameMenuController.setSpace();
                    break;
                case "R":
                    gameMenuController.restartGame();
                    break;
                case "P" :
                    GetPossibleValuesView view = new GetPossibleValuesView(theBoard);
                    view.getInput();
                    break;
                case "H":
                    gameMenuController.displayHelpMenu();
                    break;
                case "O":
                    gameMenuController.solve();
                    break;
                case "Q":
                    break;
                default: 
                    System.out.println("Invalid command. Please enter a valid command!");
                    continue;
            }
        } while (!command.equals("Q"));
        
        return;
    }
    
    public final void display() {
        System.out.println(theBoard.toString());
        System.out.println("\n============= Commands ==============");
        for(String[] command : menuItems) {
            System.out.println("" + command[0] + "\t" + command[1]);
        }
        System.out.println("\n==================================\n");
    }
    
    
    private class GameMenuController {
        private Board theBoard;

        private GetCellController getCellController;

        public GameMenuController() {}

        public void setBoard(Board theBoard) {
            this.theBoard = theBoard;
            this.getCellController = new GetCellController(theBoard);
        }

        public void setSpace() {
             System.out.println();
            System.out.println(helpBorder());

            CoordinateWrapper coordinates = getCellController.promptForCoordinates();

            if(theBoard.canSetCell(coordinates)) {
                int value = GetValueController.promptForValue();
                theBoard.setValueAt(coordinates, value);
            }

           System.out.print(helpBorder());
        }

        public void restartGame() {
             System.out.println();
            System.out.println(helpBorder());
            System.out.println("Coming Soon!");
           System.out.print(helpBorder()); 
        }

        public void solve() {
              System.out.println();
            System.out.println(helpBorder());
            System.out.println("Coming Soon!");
           System.out.print(helpBorder());
        }

        public void displayHelpMenu() {
            HelpMenuView helpMenu = new HelpMenuView();
            helpMenu.getInput();
        }

        private String helpBorder() { 
            return "=========================";
        }
    }

}
