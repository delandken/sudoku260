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
public class MainMenuView {
    private final static String[][] menuItems = {
        {"N", "New Game"},
        {"S", "Settings"},
        {"H", "Help"},
        {"Q", "Quit"}
    };
    
    private MainMenuController mainMenuController = new MainMenuController();
    
    public MainMenuView() {}
    
    public void getInput() {
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();
            
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch(command) {
                case "N":
                    mainMenuController.startNewGame();
                    break;
                case "S":
                    mainMenuController.displaySettingsMenu();
                    break;
                case "H":
                    mainMenuController.displayHelpMenu();
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
        System.out.println("\n============= Main Menu ==============");
        for(String[] command : menuItems) {
            System.out.println("" + command[0] + "\t" + command[1]);
        }
        System.out.println("\n==================================\n");
    }
}
