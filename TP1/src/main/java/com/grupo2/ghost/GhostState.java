package com.grupo2.ghost;

import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public abstract class GhostState {

	public GhostState() {
	}

	/**
	 * Polymorphicaly calls one of the "move" methods implemented by the derivative classes.
	 */
	public abstract void move();

	/**
	 * @return True if the State of the ghost is "Dead". False otherwise.
	 */
	public abstract boolean isDead();

	/**
	 * ***************TRANSITION OF STATES********************
	 */
	/**
	 * @return the next state of the ghost.
	 */
	public abstract GhostState returnNextState();

	public abstract GhostState convertToPrey();

	public abstract GhostState die();
        
        public abstract GhostState collideWithPacman();

}
