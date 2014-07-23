/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.byui.teamawesome.sudoku260.uicomponents;

import edu.byui.teamawesome.sudoku260.Board;
import edu.byui.teamawesome.sudoku260.Board.Cell;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    
    private ActionListener changeListener;
    
    public TextCell(Cell cell) {
        super();
        this.cell = cell;
        this.setEditable(!cell.isFixed());
        
        this.setText(Board.valueTranslator.getValueAtOrdinal(cell.getValue() - 1).toString());
    }
    
    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    public void refresh() {
        if(this.cell.isValid()) {
            setBackground(Color.WHITE);
        } else {
            setBackground(Color.RED);
        }
    }
    
    public void setChangeListener(ActionListener changeListener) {
        this.changeListener = changeListener;
    }
    
    public void triggerChange(ActionEvent event) {
        if(changeListener != null) {
            changeListener.actionPerformed(event);
        }
    }

    public void retranslate() {
        if(cell.getValue() != 0) {
            setText(Board.valueTranslator.getValueAtOrdinal(cell.getValue()));
        }
    }
    
    public ArrayList<Integer> getPossibleValues() {
        return cell.getPossibleValues();
    }
    
    
    private class LimitDocument extends PlainDocument {
            public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
                if (str == null) return;
                str = str.toUpperCase();
                if (Board.valueTranslator.isValidValue(str)) { 
                    if (getLength() + str.length() <= 1) {
                        super.insertString(offset, str, attr);
                    } else {
                        setText(str);
                    }
                    
                    cell.setValue(Board.valueTranslator.getOrdinalForValue(str));
                    triggerChange(new ActionEvent(this, 500, "" + cell.getValue()));
                }
            }
            
            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);
                cell.setValue(0);
                triggerChange(new ActionEvent(this, 500, "" + cell.getValue()));
            }
        }
   
    
}
