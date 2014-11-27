package com.grupo2.interfaces;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Cell;

/**
 *
 * @author fibrizo
 */
public interface Positionable {

    public Coordinate getPosition();

    public Cell getCurrentCell();
}
