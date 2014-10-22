package com.grupo2.ghost;

import com.grupo2.ghostState.Personality;
import com.grupo2.character.Direction;
import com.grupo2.cell.Cell;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public abstract class GhostState {

	public GhostState() {
	}

	/**
	 * Polymorphicaly calls one of the "move" methods implemented by the derivative classes.
	 * @param personality the personality holds the logic for the movement of a hunter
         * @param allowedDirections the list of directions that the ghost has available to move to
         * @return the direction chosen by the actual movement strategy holded by the personality
         */
	public abstract Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections);

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
