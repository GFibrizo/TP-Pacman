package com.grupo2.controller;

import com.grupo2.character.Direction;

/**
 *
 * @author ivan
 */
public class Controller {

    private InputReader reader;

    public Controller(InputReader reader) {
        this.reader = reader;
    }

    public InputReader getReader() {
        return this.reader;
    }

    public Direction getPacmanNextDirection() {
        return this.reader.getNextDirection();
    }
}
