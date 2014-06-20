/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sudoku260.Cell;
//import sudoku260.CellGroup;
//
///**
// *
// * @author Ken
// */
//public class CellGroupTest {
//    
//    private CellGroup cellGroup;
//    
//    public CellGroupTest() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
//
//    @Test
//    public void testHappyPath() {
//        Cell validCell = new Cell();
//        validCell.setValue(6);
//        
//        cellGroup.addCell(validCell);
//        assertTrue(cellGroup.isValueAllowed(5));
//    }
//    
//    @Test
//    public void duplicateNumbersNotAllowed() {
//        Cell validCell = new Cell();
//        validCell.setValue(5);
//        cellGroup.addCell(validCell);
//        
//        assertFalse(cellGroup.isValueAllowed(5));
//    }
//    
//    @Test
//    public void duplicateInArrayNotAllowed() {
//        for(int i = 1; i <= 3; i++) {
//            Cell theCell = new Cell();
//            theCell.setValue(i);
//            cellGroup.addCell(theCell);
//        }
//        
//        assertFalse(cellGroup.isValueAllowed(3));
//    }
//    
//    @Test
//    public void moreDuplicateTest() {
//        for(int i = 4; i <= 6; i++) {
//            Cell theCell = new Cell();
//            theCell.setValue(i);
//            cellGroup.addCell(theCell);
//        }
//        
//        assertFalse(cellGroup.isValueAllowed(4));
//    }
//    
//    @Test
//    public void tenIsInvalid() {
//        Cell validCell = new Cell();
//        validCell.setValue(1);
//        cellGroup.addCell(validCell);
//        
//        assertFalse(cellGroup.isValueAllowed(10));
//        
//    }
//    
//    @Test
//    public void zeroIsInvalid() {
//        Cell validCell = new Cell();
//        validCell.setValue(1);
//        cellGroup.addCell(validCell);
//        
//        assertFalse(cellGroup.isValueAllowed(0));
//        
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
//}
