/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.controller;

import com.grupo2.character.Direction;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Familia
 */
public class KeyBoardReader implements InputReader, KeyListener {

    private Direction readedDirection;

    /**
     * @return Direction, the direction obtained from the processing of the
     * key events.
     */
    @Override
    public Direction getNextDirection() {
        return readedDirection;
    }

    /**
     * Detection and processing of typed keys events.
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        detectKey(e);
    }

    /**
     * Detection and processing of pressed keys events.
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        detectKey(e);
    }

    /**
     * Detection and processing of released keys events.
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    /**
     * Detection and processing of the key events.
     * @param e of type KeyEvent, the incoming event sent from the keyboard.
     */
    private void detectKey(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            readedDirection = new RightDirection();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            readedDirection = new LeftDirection();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            readedDirection = new UpDirection();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            readedDirection = new DownDirection();
        } else {
            readedDirection = new NullDirection();
        }
    }

}
