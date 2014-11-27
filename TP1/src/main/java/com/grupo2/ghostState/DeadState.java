package com.grupo2.ghostState;

import com.grupo2.ghost.Personality;
import com.grupo2.board.Board;
import com.grupo2.character.Cell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.NullDirection;
import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.ChaseStrategy;
import com.grupo2.movementStrategies.MovementStrategy;
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
		velocity = Constants.getInitialVelocity();
		finishedMovement = 0;
		movement = new ChaseStrategy();
		movement.setTarget(Board.getInstance().getMaze().getGhostsBegining());
	}

	@Override
	public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
		time++;
		//return movement.getNewDirection(allowedDirections);
		return new NullDirection();
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
		return this;
	}

	@Override
	public GhostState die() {
		return this;
	}

	@Override
	public GhostState collideWithPacman() {
		return this;
	}

	@Override
	public String toString() {
		return "muerto";
	}

	@Override
	public boolean testIfAbleToChase() {
		return false;
	}

	@Override
	public boolean testIfAbleToStopChase() {
		return false;
	}

	@Override
	public boolean isPrey() {
		return false;
	}

	@Override
	public boolean isHunter() {
		return false;
	}
}
