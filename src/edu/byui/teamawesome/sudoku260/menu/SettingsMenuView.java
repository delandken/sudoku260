/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.menu;

import edu.byui.teamawesome.sudoku260.Sudoku260;
import java.util.Scanner;

/**
 *
 * @author AshleyFaust
 */
public class SettingsMenuView extends Menu {
    private static String playerName = "Player 1";
    
    private static GameDifficulty currentDifficulty;
    
    public SettingsMenuView() {
        menuItems.put("N", new ChangePlayerHandler());
        menuItems.put("D", new ChangeDifficultyHandler());
    }
 
    private static final class ChangePlayerHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Change Name";
        }

        @Override
        public void handleIt() {
            //Prompt the user for our input:
            System.out.print("Enter New Player Name: ");
            playerName = Sudoku260.input.nextLine();
        }
        
    }
    
    private static final class ChangeDifficultyHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Change Difficulty";
        }

        @Override
        public void handleIt() {
            do {
               //display options to user
               System.out.println("Enter easy, medium or hard.");
               String response = Sudoku260.input.nextLine();

               if(response.equals("q")) {
                   break;
               }

               if(response == "easy" ) {
                   currentDifficulty = GameDifficulty.EASY;
                   break;
               }

               if (response == "medium") {
                   currentDifficulty = GameDifficulty.MEDIUM;
                   break;
               }

               if (response == "hard") {
                   currentDifficulty = GameDifficulty.HARD;
                   break;
               }
               else System.out.println("Invalid option.");
           } while(true);
        }
        
    }
    
}

