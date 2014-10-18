package com.grupo2.cell;

import com.grupo2.character.Coordinate;

/**
 *
 * @author mauri
 */
public interface Cell {
    public boolean isTransitable();
    public Coordinate getPosition();
    public boolean isTheSame(Cell other);
}