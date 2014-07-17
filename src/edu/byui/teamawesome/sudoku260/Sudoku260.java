/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260;

import edu.byui.teamawesome.sudoku260.exceptions.MenuExceptions;
import edu.byui.teamawesome.sudoku260.frames.MainFrame;
import edu.byui.teamawesome.sudoku260.menu.MainMenuView;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ken
 */
public class Sudoku260 {

    /**
     * @param args the command line arguments
     */
    
    private static String playerName;
    private static String instructions = "Welcome to Sudoku! This game is really fun! You're gonna like it.";
    private static Board theBoard;
    
    private static MainFrame mainFrame;
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
//        Sudoku260 theGame = new Sudoku260();
//        theGame.getName();
//        theGame.displayHelp();
//        theGame.theBoard = new Board();
//        
//        Cell aNewSquare = new Cell();
//        aNewSquare.setValue(8);
//        
//        theGame.theBoard.setValueAt(0, 0, 4);
//        System.out.println("The value of the square is:" + aNewSquare.getValue());
//        System.out.println("The value at 0, 0 is:" + theGame.theBoard.getValueAt(0, 0));
//        System.out.println("The difficulty is:" + theGame.theBoard.getDifficulty());
//        
//        //The cell group class:
//        CellGroup cells = new CellGroup();
//        System.out.println("The group is valid? " + cells.isValid());
//        cells.addCell(aNewSquare);
//        System.out.println("Is 8 allowable? " + cells.isValueAllowed(8));
//        
//        HelpMenuView helpMenu = new HelpMenuView();
//        helpMenu.getInput();
        
//        MainMenuView mainMenu = new MainMenuView();
//        try {
//            mainMenu.getInput();
//            
////        HighScoreListView highscores = new HighScoreListView();
////        highscores.addHighScore(10);
////        highscores.addHighScore(5);
////        highscores.addHighScore(30);
////        highscores.addHighScore(20);
////        highscores.addHighScore(50);
////        highscores.addHighScore(105);
////        highscores.addHighScore(200);
//        } catch (MenuExceptions ex) {
//            System.out.println(ex.getMessage());
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        finally {
//            input.close();
//        }
        
        try {
            Sudoku260 game = new Sudoku260();
            
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    Sudoku260.mainFrame = new MainFrame();
                    Sudoku260.mainFrame.setVisible(true);
                }
                
            });
            
            
        } catch (Throwable ex) {
            System.out.println(ex);
        } finally {
            if(Sudoku260.mainFrame != null) {
                Sudoku260.mainFrame.dispose();
            }
        }
    }
    
    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.playerName = input.next();
    }
    
    public void displayHelp() {
        System.out.println(this.instructions);
    }
}
