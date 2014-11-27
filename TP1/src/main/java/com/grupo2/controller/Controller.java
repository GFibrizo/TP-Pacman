package com.grupo2.controller;

import com.grupo2.character.Direction;

/**
 *
 * @author ivan
 */
public class Controller {

    private InputReader reader;

    /**
     * Constructor of the class Controller.
     *
     * @param reader of type InputReader
     */
    public Controller(InputReader reader) {
        this.reader = reader;
    }

    /**
     * @return the reader.
     */
    public InputReader getReader() {
        return this.reader;
    }

    /**
     * @return the direction of type Direction readed by the reader.
     */
    public Direction getPacmanNextDirection() {
        return this.reader.getNextDirection();
    }
}
