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
public class Sudoku260 {

    /**
     * @param args the command line arguments
     */
    
    private String playerName;
    private String instructions = "Welcome to Sudoku! This game is really fun! You're gonna like it.";
    private Board theBoard;
    
    public static void main(String[] args) {
        Sudoku260 theGame = new Sudoku260();
        theGame.getName();
        theGame.displayHelp();
        theGame.theBoard = new Board();
        theGame.theBoard.setValueAt(0, 0, 5);
        System.out.println("The value at 0, 0 is:" + theGame.theBoard.getValueAt(0, 0));
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