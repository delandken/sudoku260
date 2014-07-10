/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.menu;

import edu.byui.teamawesome.sudoku260.exceptions.MenuExceptions;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                gameMenu.getInput();
            } catch (MenuExceptions ex) {
                System.out.println(ex.getMessage());
            }
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
            try {
                settingsMenu.getInput();
            } catch (MenuExceptions ex) {
                System.out.println(ex.getMessage());
            }
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
            try {
                helpMenu.getInput();
            } catch (MenuExceptions ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
}