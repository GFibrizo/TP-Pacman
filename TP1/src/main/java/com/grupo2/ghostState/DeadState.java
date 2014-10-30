package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.MovementStrategy;
import com.grupo2.movementStrategies.SearchCageStrategy;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class DeadState extends GhostState {

    private float time;
    private final MovementStrategy movement;

    public DeadState() {
        time = 0;
        movement = new SearchCageStrategy();
    }

    @Override
    public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
        time++;
        return movement.getNewDirection(allowedDirections);
    }

    /**
     * @return True, because the State of the Ghost is "Dead".
     */
    @Override
    public boolean isDead() {
        return true;
    }

    /* @return the next state of the Ghost. returns this, except that the time
     * has passed. In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.getDeadLimitTime()) {
            return new HunterState();
        }
        return this;
    }

    @Override
    public GhostState convertToPrey() {
        throw new AssertionError("A dead Ghost can't be forced to convert into Prey");
    }

    @Override
    public GhostState die() {
        throw new AssertionError("A dead Ghost can't die again");
    }

    @Override
    public GhostState collideWithPacman() {
        return this;
    }

	@Override
	public String toString() {
		return "muerto";
	}
}
