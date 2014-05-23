/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

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
}

