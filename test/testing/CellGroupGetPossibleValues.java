/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sudoku260.Cell;
//import sudoku260.CellGroup;

/**
 *
 * @author Ken
 */
public class CellGroupGetPossibleValues {
    
    public CellGroupGetPossibleValues() {
    }
    
//    private CellGroup cellGroup;
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//    }
//
//    @BeforeMethod
//    public void setUpMethod() throws Exception {
//        cellGroup = new CellGroup();
//    }
//
//    @AfterMethod
//    public void tearDownMethod() throws Exception {
//    }
//    
//    @Test
//    public void testHappyPath() {
//       //Add our valid inputs:
//        Cell aCell = new Cell();
//        aCell.setValue(1);
//        cellGroup.addCell(aCell);
//        
//        aCell = new Cell();
//        aCell.setValue(2);
//        cellGroup.addCell(aCell);
//        
//        aCell = new Cell();
//        aCell.setValue(5);
//        cellGroup.addCell(aCell);
//        
//        aCell = new Cell();
//        aCell.setValue(7);
//        cellGroup.addCell(aCell);
//        
//        ArrayList<Integer> possibleValues = cellGroup.getPossibleValues();
//        assertTrue(possibleValues.contains(3));
//        assertTrue(possibleValues.contains(4));
//        assertTrue(possibleValues.contains(6));
//        assertTrue(possibleValues.contains(8));
//        assertTrue(possibleValues.contains(9));
//    }
//    
//    @Test
//    public void testFullResults() {
//        Cell aCell;
//      for(int i = 0; i < 10; i++) {
//          aCell = new Cell();
//          aCell.setValue(i);
//          cellGroup.addCell(aCell);
//      }
//      
//      ArrayList<Integer> possibleValues = cellGroup.getPossibleValues();
//      assert(possibleValues.size() == 0);
//    }
//    
//    @Test
//    public void testNegativeValueResults() {
//        Cell aCell;
//        aCell = new Cell();
//        aCell.setValue(-1);
//        cellGroup.addCell(aCell);
//      
//      ArrayList<Integer> possibleValues = cellGroup.getPossibleValues();
//      
//      for(int i = 1; i < 10; i++) {
//          assertTrue(possibleValues.contains(i));
//      }
//    }
//    
//     @Test
//    public void testTenValueResults() {
//        Cell aCell;
//        aCell = new Cell();
//        aCell.setValue(10);
//        cellGroup.addCell(aCell);
//      
//      ArrayList<Integer> possibleValues = cellGroup.getPossibleValues();
//      
//      for(int i = 1; i < 10; i++) {
//          assertTrue(possibleValues.contains(i));
//      }
//    }
}
