package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.constants.Constants;
import com.grupo2.movementStrategies.ScapeStrategy;

/**
 *
 * @author fibrizo
 */
public class PreyState extends GhostState {

    private float time = 0;
    private PreyMovement movement;

    public PreyState() {
        movement = new ScapeStrategy();
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
     *         has passed. In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.getPreyLimitTime()) {
                return new HunterState();
        }
        return this;
    }

    @Override
    public GhostState convertToPrey() {
        return new PreyState();
    }

    @Override
    public GhostState die() {
        return new DeadState();
    }
    
    @Override
    public GhostState collideWithPacman(){
        return new DeadState();
    }

}
