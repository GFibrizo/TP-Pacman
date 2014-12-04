package com.grupo2.controller;

import com.grupo2.character.Direction;

/**
 *
 * @author ivan
 */
public interface InputReader {

    /**
     *
     * @return the next direction obtained from the Reader
     */
    Direction getNextDirection();
}
