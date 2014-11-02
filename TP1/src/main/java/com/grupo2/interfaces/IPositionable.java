package com.grupo2.interfaces;

import com.grupo2.character.Coordinate;
import com.grupo2.cell.Cell;

/**
 *
 * @author fibrizo
 */
public interface IPositionable {

    public void setPosition(Coordinate pos);

    public void setPosition(int x, int y);

    public Coordinate getPosition();
    
    public Cell getCurrentCell();
}
