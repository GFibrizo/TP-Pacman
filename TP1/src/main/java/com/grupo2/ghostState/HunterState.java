package com.grupo2.ghostState;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.FirstRageStrategy;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

    float time;
    private RageMovement rage;
    
    public HunterState() {
        time = 0;
        rage = new FirstRageStrategy();
    }
    
    @Override
    public void move() {
        this.time++;
        this.rage.move();
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
