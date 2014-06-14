/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.Scanner;

/**
 *
 * @author vdelake
 */
public class GetValueController {
    public static int promptForValue() {
         Scanner in = new Scanner(System.in);
         int value;
         do {
             System.out.println("Enter a Value (1 - 9):");
             String response = in.nextLine();
             
             if(response.equals("q")) {
                 return 0;
             }
             
             try {
                 value = Integer.parseInt(response);
                 if(value >= 0 && value <= 9) 
                     return value; 
             } catch (NumberFormatException ex) {}
             System.out.println("Invalid value.");
         } while(true);
    }
}
