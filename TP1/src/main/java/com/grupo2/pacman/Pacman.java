/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.pacman;
import com.grupo2.character.Character;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character {
    
    private Direction nextDirection;
    private boolean alive; 
    
    public Pacman() {
        alive = true;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDead() {
        return alive;
    }

    @Override
    public void chooseDirection() {
       nextDirection = direction;
    }
    
    
    
}
