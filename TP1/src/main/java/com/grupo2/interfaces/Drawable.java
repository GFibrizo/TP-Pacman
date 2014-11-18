/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.interfaces;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;

/**
 *
 * @author Familia
 */
public interface Drawable {

    public Coordinate getPosition();

    public Cell getCurrentCell();

    public Direction getDirection();
}
