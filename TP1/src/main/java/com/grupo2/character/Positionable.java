package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public interface Positionable {

    /**
     *
     * @return the Coordinate of the Positionable
     */
    public Coordinate getPosition();

    /**
     *
     * @return the Cell of the Positionable
     */
    public Cell getCurrentCell();
}
