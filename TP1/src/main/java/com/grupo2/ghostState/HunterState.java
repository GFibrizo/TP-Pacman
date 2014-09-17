package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.ghost.MovementStrategy;
import com.grupo2.movementStrategies.FirstLevelRage;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

    float time = 0;
    private Rage rage;
    
    private HunterState(Rage rage) {
        super(rage);
        this.rage = rage;
    }

    public HunterState() {
        this(new FirstLevelRage());
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
     * @return the next state of the Ghost. returns this always, since
     * HunterState hasn't a next state.
     */
    @Override
    public GhostState returnNextState() {
        return this;
    }
}
