package com.grupo2.ghost;

/**
 *
 * @author fibrizo
 */
public abstract class GhostState {
    protected MovementStrategy movement;

    public GhostState(MovementStrategy movement) {
        this.movement = movement;
    }

    /**
     * Polymorphicaly calls one of the "move" methods implemented by the
     * derivative classes.
     */
    public abstract void move();

    /**
     * @return True if the State of the ghost is "Dead". False otherwise.
     */
    public abstract boolean isDead();

    /**
     * @return the next state of the ghost.
     */
    public abstract GhostState returnNextState();

}
