package com.grupo2.ghost;

/**
 *
 * @author fibrizo
 */
public abstract class GhostState {

    public GhostState() {
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
    
    
    /**DOUBLE DISPATCH FOR GHOSTS EATEN BY OTHER CHARACTERS**/
    
    /**
     * Te collision of two Ghosts doesn't change the state of any
     * of the two.
     * @param ghost is the other Ghost.
     */
    public void beEaten(Ghost ghost) {
        // Do nothing
    }
    
    /**
     * The state turns to dead if the state is Prey, 
     * and keeps the same if the state is Hunter .
     * If the Ghost is in Dead state, it keeps in that state.
     * @param pacman is the Pacman that is colliding with this.
     */
    //public abstract void beEaten(Pacman pacman);

}
