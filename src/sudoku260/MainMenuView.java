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

/**
 *
 * @author Ken
 */
public class MainMenuController {
    public void startNewGame() {
       GameMenuView gameMenu = new GameMenuView(new Board());
       gameMenu.getInput();
    }
    
    public void displaySettingsMenu() {
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

/**
 *we need to make sure we have the view high score and high score average options on the main menu 
 * @author vdelake
 */
public class HighScoreListView {
    private int[] highScores = new int[10];
    private int currentIndex = 0;
    
    public void addHighScore(int highScore) {
        if(currentIndex < 10) {
            highScores[currentIndex++] = highScore;
        } else {
            highScores[currentIndex] = highScore;
        }
        
        sortScores();
        displayHighScores();
    }
    
    public void sortScores() {
        int j; //Number of items sorted so far.
        int key; //current item being sorted.
        int i; //Index for looper.
        
        //Loop through every item in our list:
        for(j = 1; j < highScores.length; j++) {
            key = highScores[j]; //Get the current item
            //Loop through our items we've already sorted, and make space for this new key.
            for(i = j - 1; (i >= 0) && (highScores[i] < key); i--) {
                highScores[i + 1] = highScores[i];
            }
            highScores[i + 1] = key;
        }
    }
    
    public void displayHighScores() {
        for(int i = 0; i < highScores.length; i++) {
            if(highScores[i] != 0) {
                System.out.println("#" + (i + 1) + ": " + highScores[i]);
            }
        }
    }
    public double GetAverage() {
        int highScoresTotal = 0;
        for(int i = 0; i < highScores.length; i++){
        highScoresTotal += highScores[i];
        }
        int average = highScoresTotal / highScores.length;
        System.out.println("The average high score is" + average + ".");
    return average;} 
    
    
}
}