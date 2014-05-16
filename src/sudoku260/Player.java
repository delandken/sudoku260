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
public class Player {
    private String playerName;
            
    public void getPlayerName(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.playerName = input.next();
    }
    public void setPlayerName(String name) {
        playerName = name;
    }
    
    public void winRate(gamesPlayed, gamesWon){
            if (gamesWon > gamesPlayed || gamesPlayed < 1){
                System.out.println ("Number must be positive");
             return false
            }
        float winRate = (gamesWon / gamesPlayed) * 200
                if (winRate == 100){
                    System.out.println ("Perfect Record! 100%");
                }
        System.out.println ("Your win percentage is" + winRate + "%");
    }
       
          
            
        
    

 
   
         }  

