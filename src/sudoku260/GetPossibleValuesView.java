/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku260;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ken
 */
public class GetPossibleValuesView {
    private Board board;
    
    public GetPossibleValuesView(Board board) {
        this.board = board;
    }
    
    public void getInput() {
        GetCellController getCellController = new GetCellController(board);
        CoordinateWrapper coordinates = getCellController.promptForCoordinates();
        ArrayList<Integer> possibleValues = board.getPossibleValuesAt(coordinates);
    }
}
