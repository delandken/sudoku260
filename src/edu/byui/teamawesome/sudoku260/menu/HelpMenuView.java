/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.menu;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ken
 */
public class HelpMenuView extends Menu {
    /* The Help Strings: */
    private static final String about = "The game of sudoku is a simple number game. The\n" +
                "board consists of a nine by nine grid. The goal of the game \n" +
                "is to fill each square with the numbers 1 - 9.";
    private static final String scoring = "Your score in Sudoku is calculated based on how fast\n" +
                "you can solve the puzzle. Faster times, means a higher score!";
    private static final String rules = "Each row, column and 3x3 square within the Sudoku\n" +
                "board must contain the values 1 through 9. There can be no duplicates.";
    
    public HelpMenuView() {
                menuItems.put("A", new AboutGameHandler());
                menuItems.put("R", new RulesHandler());
                menuItems.put("S", new ScoringHandler());
    }
    
        private static class AboutGameHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "About Game";
        }

        @Override
        public void handleIt() {
            System.out.println("about");
        }
        
    }
    
        private static class RulesHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Rules";
        }

        @Override
        public void handleIt() {
            System.out.println(rules);
        }
        
    }
       private static class ScoringHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Scoring";
        }

        @Override
        public void handleIt() {
            System.out.println(scoring);
        }
        
    }
//    private final static String[][] menuItems = {
//        {"A", "About the game"},
//        {"R", "The rules"},
//        {"S", "Scoring"},
//        {"Q", "Quit Help"}
//    };
//    
//    private HelpMenuController helpMenuControl = new HelpMenuController();
//    
//    public HelpMenuView() {}
//    
//    public void getInput() {
//        String command;
//        Scanner inFile = Sudoku260.input;
//        
//        do {
//            this.display();
//            
//            command = inFile.nextLine();
//            command = command.trim().toUpperCase();
//            
//            switch(command) {
//                case "A":
//                    this.helpMenuControl.displayAbout();
//                    break;
//                case "R":
//                    this.helpMenuControl.displayRules();
//                    break;
//                case "S":
//                    this.helpMenuControl.displayScore();
//                    break;
//                case "Q":
//                    break;
//                default: 
//                    System.out.println("Invalid command. Please enter a valid command!");
//                    continue;
//            }
//        } while (!command.equals("Q"));
//        
//        return;
//    }
//    
//    public final void display() {
//        System.out.println("\n============= Help Menu ===============");
//        for(String[] command : menuItems) {
//            System.out.println("" + command[0] + "\t" + command[1]);
//        }
//        System.out.println("\n==================================\n");
//    }
//
///**
// *
// * @author Ken
// */
//public class HelpMenuController {
//    public void displayAbout() {
//        System.out.println();
//        System.out.println(helpBorder());
//        System.out.println();
//       System.out.print(helpBorder());
//    }
//    
//    public void displayRules() {
//         System.out.println();
//        System.out.println(helpBorder());
//        System.out.println();
//       System.out.print(helpBorder());
//    }
//    
//    public void displayScore() {
//          System.out.println();
//        System.out.println(helpBorder());
//        System.out.println("Your score in Sudoku is calculated based on how fast\n" +
//                "you can solve the puzzle. Faster times, means a higher score!");
//       System.out.print(helpBorder());
//    }
//    
//    private String helpBorder() { 
//        return "=========================";
//    }
//}
}