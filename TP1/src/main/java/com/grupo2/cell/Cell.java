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

    public Cell getLowerCell();

    public Cell getUpperCell();

    public Cell getLeftCell();

    public Cell getRightCell();

    public boolean canGoUp();
    
    public boolean canGoDown();
    
    public boolean canGoLeft();
    
    public boolean canGoRight();
}
