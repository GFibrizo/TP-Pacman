/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character.cell;
import com.grupo2.character.Collitionable;
import com.grupo2.character.Cell;
import com.grupo2.character.Coordinate;

/**
 *
 * @author mauri
 */
public class TransitableCell {
    
    private Collitionable content;
    private Cell upperCell;
    private Cell lowerCell;
    private Cell leftCell;
    private Cell rightCell;
    private Coordinate position;
    
    public TransitableCell(Coordinate position) {
        this.position = position;
    }
    
    public void initializeCell(Cell up, Cell down, Cell left, 
                                Cell right, Collitionable newContent) {
        upperCell = up;
        lowerCell= down;
        leftCell = left;
        rightCell = right;
        content = newContent;
    }
    
    
    public boolean isTransitable() {
        return true;
    }
    
    public Collitionable getContent() {
        return content;
    }
    
    
}
