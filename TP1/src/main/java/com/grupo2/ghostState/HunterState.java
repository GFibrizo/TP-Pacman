package com.grupo2.ghostState;

import com.grupo2.ghost.GhostState;
import com.grupo2.constants.Constants;
import com.grupo2.character.Direction;
import com.grupo2.cell.Cell;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

	private float time;
        private float velocity;

	public HunterState() {
            velocity = Constants.getInitialVelocity();
	}
        

	@Override
	public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
            return personality.getNewDirection(allowedDirections);
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
        
	public void incrementRage() {
            velocity++;
	}


}
