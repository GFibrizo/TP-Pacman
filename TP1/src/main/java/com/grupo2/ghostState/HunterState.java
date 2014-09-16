/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.PreyMovement;
import com.grupo2.movementStrategies.FirstRageMovement;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

    float time = 0;
    //Velocity here? or in the Rage (ira) classes?

    public HunterState() {
        super(new FirstRageMovement());
    }

    @Override
    public void move() {
        this.time++;
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
     * ************************************************
     */
    /**
     * ************************************************
     */
    /**
     * @return the next state of the Ghost. returns this always, since
     * HunterState hasn't a next state.
     */
    @Override
    public GhostState returnNextState() {
        return this;
    }
}
