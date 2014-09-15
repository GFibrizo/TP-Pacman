/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;
import com.grupo2.ghost.GhostState;
import com.grupo2.constants.Constants;

/**
 *
 * @author fibrizo
 */
public class PreyState extends GhostState {
    
    float time = 0;
    
    /***************************************************/
    /***************************************************/
    
    
    public void move() {
        time++;
        // Random movement
    }
    
    /***************************************************/
    /***************************************************/
    
    /**
     * @return False, because the State of the Ghost isn't "Dead".
     */
    @Override
    public boolean isDead() {
        return false;
    }    
    
    /***************************************************/
    /***************************************************/
    
    /**
     * @return the next state of the Ghost.
     * returns this, except that the time has passed.
     * In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.PREY_LIMIT_TIME)
            return new HunterState();
        return this;
    }
    
}
