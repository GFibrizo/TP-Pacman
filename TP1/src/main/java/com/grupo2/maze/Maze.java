package com.grupo2.maze;

import com.grupo2.character.Coordinate;
import com.grupo2.interfaces.IPositionable;

/**
 *
 * @author fibrizo
 */
public interface Maze {

    public Coordinate getPacmanBegining();
    public Coordinate getGhostBegining();
    public boolean areInTheSameCell(IPositionable entity, IPositionable other);
}
