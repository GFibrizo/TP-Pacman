/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.controller;
import com.grupo2.directions.RightDirection;

import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class MockReader implements InputReader {

    @Override
    public Direction getNextDirection() {
        return new RightDirection();
    }
    
}
