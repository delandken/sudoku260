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
public class MainMenuView extends AbstractMenu {
    static {
        menuItems.put("N", new NewGameHandler());
        menuItems.put("S", new SettingsHandler());
        menuItems.put("H", new HelpMenuHandler());
    }
    private static class NewGameHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "New Game";
        }

        @Override
        public void handleIt() {
            GameMenuView gameMenu = new GameMenuView(new Board());
            gameMenu.getInput();
        }
        
    }
    
    private static class SettingsHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Settings";
        }

        @Override
        public void handleIt() {
            SettingsMenuView settingsMenu = new SettingsMenuView();
            settingsMenu.getInput();
        }
        
    }
    
    private static class HelpMenuHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "Help Menu";
        }

        @Override
        public void handleIt() {
            HelpMenuView helpMenu = new HelpMenuView();
            helpMenu.getInput();
        }
        
    }
}