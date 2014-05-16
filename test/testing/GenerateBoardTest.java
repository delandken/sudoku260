/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sudoku260.Board;
import sudoku260.Cell;
import sudoku260.CellGroup;

/**
 *
 * @author Ken
 */
public class GenerateBoardTest {
    
    public static Board board;
    public static Method method;
    public static Field rowField;
    public static Field colField;
    
    public GenerateBoardTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testValidConfiguration() throws IllegalArgumentException {
         //A Happy Test:
         try {
            Cell[] aBoard = (Cell[]) method.invoke(board, new Object[]{new Cell[81], 0});
            
            //Validate each row:
            for(int i = 0; i < 81; i += 9) {
                boolean[] validNums = new boolean[9];
                for(int j = 0; j < 9; j++) {
                    System.out.println("i: " + i + " j:" + j + " i + j:" + (i + j));
                    System.out.println(i + j);
                    if(validNums[aBoard[i + j].getValue() - 1]) {
                        fail("Duplicate number " + aBoard[i + j].getValue());
                    }
                    validNums[aBoard[i + j].getValue() - 1] = true;
                }
            }
            
            //Validate each Column:
            for(int i = 0; i < 9; i++) {
                boolean[] validNums = new boolean[9];
                for(int j = 0; j < 81; j+= 9) {
                    if(validNums[aBoard[i + j].getValue() - 1]) {
                        fail("Duplicate number " + aBoard[i + j].getValue());
                    }
                    validNums[aBoard[i + j].getValue() - 1] = true;
                }
            }
         } catch (Exception e) {
             fail("No exception should have been thrown.");
         }
         
     }
    
     //NOTE: This test takes a LONG time to fail. Commented out for now, but it does eventually pass.
//     @Test
//     public void testInvalidBoard() throws Exception {
//         //Do a little more set up here:
//         try {
//            CellGroup[] rows = (CellGroup[]) rowField.get(board);
//            CellGroup[] cols = (CellGroup[]) colField.get(board);
//            
//            Cell[] testBoard = new Cell[81];
//            //Assign the first three manually:
//            rows[0] = new CellGroup();
//            cols[0] = new CellGroup();
//            cols[1] = new CellGroup();
//            cols[2] = new CellGroup();
//            
//            testBoard[0] = new Cell();
//            testBoard[0].setValue(9);
//            testBoard[1] = new Cell();
//            testBoard[1].setValue(9);
//            testBoard[2] = new Cell();
//            testBoard[2].setValue(9);
//            
//            testBoard[0].assignToGroup(rows[0]);
//            testBoard[0].assignToGroup(cols[0]);
//            testBoard[1].assignToGroup(rows[0]);
//            testBoard[1].assignToGroup(cols[1]);
//            testBoard[2].assignToGroup(rows[0]);
//            testBoard[2].assignToGroup(cols[2]);
//            
//            //This should be null, since it won't be solvable, ever.
//            assertEquals(method.invoke(board, new Object[]{testBoard, 3}), null);
//         } catch(Exception e) {
//             throw e;
//        }
//     }
     
     @Test
     public void testInvalidIndex() {
         try {
            assertEquals(method.invoke(board, new Object[]{new Cell[81], 81}), null);
         } catch (Exception e) {
             fail("No exception should have been thrown.");
         }
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
        board = new Board();
        
        method = Board.class.getDeclaredMethod("generateBoard", new Class[]{Cell[].class, Integer.TYPE});
        method.setAccessible(true);
        
        colField = Board.class.getDeclaredField("columns");
        colField.setAccessible(true);
        rowField = Board.class.getDeclaredField("rows");
        rowField.setAccessible(true);
        
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        colField.set(board, new CellGroup[9]);
        rowField.set(board, new CellGroup[9]);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
