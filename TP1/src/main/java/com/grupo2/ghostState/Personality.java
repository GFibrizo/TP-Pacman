/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;
import com.grupo2.character.Direction;
import com.grupo2.movementStrategies.MovementStrategy;

/**
 *
 * @author fibrizo
 */
public abstract class Personality {
    
    protected int vision;
    protected MovementStrategy movement;
    
    public abstract Direction getNewDirection();
    public abstract void beginPacmanChase();
    public abstract void stopPacmanChase();
    
    public int getVision() {
        return vision;
    }
    
}
