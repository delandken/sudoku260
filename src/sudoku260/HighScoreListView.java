/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

/**
 *
 * @author vdelake
 */
public class HighScoreListView {
    private int[] highScores = new int[10];
    private int currentIndex = 0;
    
    public void addHighScore(int highScore) {
        if(currentIndex < 10) {
            highScores[currentIndex++] = highScore;
        } else {
            highScores[currentIndex] = highScore;
        }
        
        sortScores();
        displayHighScores();
    }
    
    public void sortScores() {
        int j; //Number of items sorted so far.
        int key; //current item being sorted.
        int i; //Index for looper.
        
        //Loop through every item in our list:
        for(j = 1; j < highScores.length; j++) {
            key = highScores[j]; //Get the current item
            //Loop through our items we've already sorted, and make space for this new key.
            for(i = j - 1; (i >= 0) && (highScores[i] < key); i--) {
                highScores[i + 1] = highScores[i];
            }
            highScores[i + 1] = key;
        }
    }
    
    public void displayHighScores() {
        for(int i = 0; i < highScores.length; i++) {
            if(highScores[i] != 0) {
                System.out.println("#" + (i + 1) + ": " + highScores[i]);
            }
        }
    }
    
}
