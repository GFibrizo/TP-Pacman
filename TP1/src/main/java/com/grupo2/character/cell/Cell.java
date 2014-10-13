package com.grupo2.character.cell;

import com.grupo2.character.Coordinate;

/**
 *
 * @author mauri
 */
public interface Cell {
    public boolean isTransitable();
    public Coordinate getPosition();
}
