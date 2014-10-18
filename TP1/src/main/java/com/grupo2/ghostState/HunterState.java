package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.MovementStrategy;
import com.grupo2.constants.Constants;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

	private float time;
	private Personality personality;
        private float velocity;

	public HunterState(Personality personality) {

            this.personality = personality;
            velocity = Constants.getInitialVelocity();
	}

	@Override
	public void getNewDirection() {
		return this.personality.getNewDirection();
	}

	/**
	 * @return False, because the State of the Ghost isn't "Dead".
	 */
	@Override
	public boolean isDead() {
		return false;
	}

	/**
	 * @return the next state of the Ghost. returns this always, since HunterState hasn't a next
	 *         state.
	 */
	@Override
	public GhostState returnNextState() {
		return this;
	}

	@Override
	public GhostState convertToPrey() {
		return new PreyState();
	}

	@Override
	public GhostState die() {
		throw new AssertionError("A hunter Ghost can't die");
	}

	@Override
	public GhostState collideWithPacman() {
		// Acá hay que "matar" al pacman.
		return this; //When a Ghost in Hunter State collides with the Pacman, nothing happens to it, so the state remains the same.

	}
        
	public HunterState incrementRage() {
		return velocity;
	}

}
