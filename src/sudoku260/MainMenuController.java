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
