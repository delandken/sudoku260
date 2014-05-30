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
public class GetDifficulty {
    
    public void getInput() {
        Scanner in = new Scanner(System.in);
        do {
            //display options to user
            System.out.println("Enter easy, medium or hard.");
            String response = in.nextLine();
            
            if(response.equals("q")) {
                break;
            }
            
            if(response == "easy" ) {
                System.out.println("You have chosen easy. Good luck!");
            }
            
            if (response == "medium") {
                System.out.println("You have chosen medium. Good luck!");
            }
            
            if (response == "hard") {
                System.out.println("You have chosen hard. Good luck!");
            }
            else System.out.println("Invalid coordinates.");
        } while(true);
    }
}

