/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.interfaces;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public interface ICharacter extends IPositionable {

    public abstract void move();
    public abstract boolean isDead();
    public void changeDirection(Direction theNewDirection);
    public void die();
}