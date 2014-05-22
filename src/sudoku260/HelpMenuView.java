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
public class HelpMenuView {
    private final static String[][] menuItems = {
        {"A", "About the game"},
        {"R", "The rules"},
        {"S", "Scoring"},
        {"Q", "Quit Help"}
    };
    
    private HelpMenuController helpMenuControl = new HelpMenuController();
    
    public HelpMenuView() {}
    
    public void getInput() {
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();
            
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch(command) {
                case "A":
                    this.helpMenuControl.displayAbout();
                    break;
                case "R":
                    this.helpMenuControl.displayRules();
                    break;
                case "S":
                    this.helpMenuControl.displayScore();
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
        System.out.println("\n==================================");
        for(String[] command : menuItems) {
            System.out.println("" + command[0] + "\t" + command[1]);
        }
        System.out.println("\n==================================\n");
    }
}
