/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author vdelake
 */
public class GetCellController {
    public CoordinateWrapper promptForCoordinates() {
        Scanner in = Sudoku260.input;
        int x, y;
        do {
            //Prompt the user for the coordinates:
            System.out.println("Enter the coordinates in the format: x y");
            String response = in.nextLine();
            
            if(response.equals("q")) {
                break;
            }
            
            //Split our string by the space:
            //For example, if I type A B, it will return an array of ["A", "B"]
            String[] coordinates = response.split(" ");
            
            if(coordinates.length == 2) {
            
                try {
                    x = Integer.parseInt(coordinates[0]);
                    y = Integer.parseInt(coordinates[1]);
                    if(x > 0 && x < 10 && y > 0 && y < 10) {
                        return new CoordinateWrapper(x, y);
                    }
                } catch (NumberFormatException ex) {
                }
            }
            
            System.out.println("Invalid coordinates.");
        } while(true);
        
        return null;
    }
}
