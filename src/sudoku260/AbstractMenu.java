/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku260;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author ken
 */
public abstract class AbstractMenu {
//    protected static String[][] menuItems;
    protected HashMap<String, MenuItemCommand> menuItems = new HashMap<String, MenuItemCommand>();
   
    public AbstractMenu(){};
 
    public void getInput() {
        String command;
        Scanner inFile = Sudoku260.input;
        
        do {
            this.display();
            
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            if(!command.equals("Q")) {
                if(menuItems.containsKey(command)) {
                    menuItems.get(command).handleIt();
                }
            }
        } while (!command.equals("Q"));
        
        return;
    }
    
    public void display() {
        System.out.println("\n~~~~~~~~~~~~ Main Menu ==============");
        for(String command : menuItems.keySet()) {
            System.out.println("" + command + "\t" + menuItems.get(command).getName());
        }
        System.out.println("Q\tQuit");
        System.out.println("\n==================================\n");
    }

}
