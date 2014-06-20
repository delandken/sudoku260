/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.Scanner;

/**
 *
 * @author AshleyFaust
 */
public class SettingsMenuView {
    private final static String[][] menuItems = {
        {"N", "Change Player Name"},
        {"D", "Change Difficulty"},
        {"Q", "Quit Menu"}
    };
    
    private SettingsMenuController SettingsMenuControl = new SettingsMenuController();
    
    public SettingsMenuView() {}
    
    public void getInput() {
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();
            
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch(command) {
                case "N":
                    this.SettingsMenuControl.displayNameChange();
                    break;
                case "D":
                    this.SettingsMenuControl.displayChangeDifficulty();
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

/**
 *
 * @author AshleyFaust
 */
    public class SettingsMenuController {
    public void displayNameChange() {
        System.out.println();
        System.out.println(menuBorder());
        System.out.println("To change your player name, please click restart on main menu.");
       System.out.print(menuBorder());
    }
    
    public void displayChangeDifficulty() {
         System.out.println();
        System.out.println(menuBorder());
        System.out.println("Changing difficulty changes the number of squares in the" +
                "matrix. This will require a restart of the game from the main menu." +
                "Then select your preferred difficulty level.");
       System.out.print(menuBorder());
    }
    
    
    private String menuBorder() { 
        return "=========================";
    }
    
    /**
    *
    * @author AshleyFaust
    */
   private class GetDifficulty {

       public void getInput() {
           Scanner in = new Scanner(System.in);
           do {
               //display options to user
               System.out.println("Enter easy, medium or hard.");
               String response = in.nextLine();

               if(response.equals("q")) {
                   break;
               }

               if(response == "easy" ) {
                   System.out.println("You have chosen easy. Good luck!");
               }

               if (response == "medium") {
                   System.out.println("You have chosen medium. Good luck!");
               }

               if (response == "hard") {
                   System.out.println("You have chosen hard. Good luck!");
               }
               else System.out.println("Invalid coordinates.");
           } while(true);
       }
    }
}
}

