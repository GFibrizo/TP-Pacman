/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.interfaces;
import com.grupo2.character.Coordinate;

/**
 *
 * @author fibrizo
 */
public interface IPositionable {
    
    public void setPosition(Coordinate pos);
    public void setPosition(int x, int y);
    public Coordinate getPosition();
}
