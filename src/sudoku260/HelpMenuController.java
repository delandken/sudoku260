/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

/**
 *
 * @author Ken
 */
public class HelpMenuController {
    public void displayAbout() {
        System.out.println();
        System.out.println(helpBorder());
        System.out.println("The game of sudoku is a simple number game. The\n" +
                "board consists of a nine by nine grid. The goal of the game \n" +
                "is to fill each square with the numbers 1 - 9.");
       System.out.print(helpBorder());
    }
    
    public void displayRules() {
         System.out.println();
        System.out.println(helpBorder());
        System.out.println("Each row, column and 3x3 square within the Sudoku\n" +
                "board must contain the values 1 through 9. There can be no duplicates.");
       System.out.print(helpBorder());
    }
    
    public void displayScore() {
          System.out.println();
        System.out.println(helpBorder());
        System.out.println("Your score in Sudoku is calculated based on how fast\n" +
                "you can solve the puzzle. Faster times, means a higher score!");
       System.out.print(helpBorder());
    }
    
    private String helpBorder() { 
        return "=========================";
    }
}
