/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.menu;

import java.util.Scanner;

/**
 *
 * @author Ken
 */
public class MainMenuView extends Menu {
    
    
    public MainMenuView() {
        menuItems.put("N", new NewGameHandler());
        menuItems.put("S", new SettingsHandler());
        menuItems.put("H", new HelpMenuHandler());
    }
    
    private static final class NewGameHandler implements MenuItemCommand {

        @Override
        public String getName() {
            return "New Game";
        }

        @Override
        public void handleIt() {
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.getInput();
        }
        
    }
    
    private static final class SettingsHandler implements MenuItemCommand {

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
    
    private static final class HelpMenuHandler implements MenuItemCommand {

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