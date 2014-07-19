/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.uicomponents;

import edu.byui.teamawesome.sudoku260.Board;
import edu.byui.teamawesome.sudoku260.Board.Cell;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ken
 */
public class TextCell extends JTextField {
    private Cell cell;
    
    public TextCell(Cell cell) {
        super("" + Board.valueTranslator.getValueAtOrdinal(cell.getValue() - 1));
       
        this.cell = cell;
        
        this.setEditable(!cell.isFixed());
        
        this.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                System.out.println(e);
            }
        });      
    }
    
    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }
    
    private class LimitDocument extends PlainDocument {
            
            public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
                if (str == null) return;

                if (Board.valueTranslator.isValidValue(str) && (getLength() + str.length()) <= 1) {
                    super.insertString(offset, str, attr);
                }
            }
        }
    
}
