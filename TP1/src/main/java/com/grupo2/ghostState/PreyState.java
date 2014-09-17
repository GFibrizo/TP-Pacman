/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.constants.Constants;
import com.grupo2.movementStrategies.PreyStrategy;

/**
 *
 * @author fibrizo
 */
public class PreyState extends GhostState {

    float time = 0;
    PreyMovement movement;

    public PreyState() {
        movement = new PreyStrategy();
    }

    @Override
    public void move() {
        time++;
        this.movement.move();
    }

    /**
     * @return False, because the State of the Ghost isn't "Dead".
     */
    @Override
    public boolean isDead() {
        return false;
    }

    /**
     * @return the next state of the Ghost. returns this, except that the time
     * has passed. In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.getPREY_LIMIT_TIME()) {
            return new HunterState();
        }
        return this;
    }
    
    @Override
    public GhostState convertToPrey() {
        throw new AssertionError("A prey Ghost can't be converted to Prey again");
    }
    
    @Override
    public GhostState die() {
        return new DeadState();
    }

}
