package com.grupo2.ghostState;

import com.grupo2.ghost.Personality;
import com.grupo2.character.Cell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.GhostState;
import com.grupo2.movementStrategies.MovementStrategy;
import com.grupo2.movementStrategies.ScapeStrategy;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class PreyState extends GhostState {

    private float time;
    private MovementStrategy movement;

    public PreyState() {
        movement = new ScapeStrategy();
        finishedMovement = 0;
        velocity = Constants.getInitialVelocity();
        time = 0;
    }

    @Override
    public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
        time++;
        Direction dir = this.movement.getNewDirection(allowedDirections);
        return dir;
    }

    /**
     * @return False, because the State of the Ghost isn't "Dead".
     */
    @Override
    public boolean isDead() {
        return false;
    }

    /**
     * @return the next state of the Ghost. returns this, except that the time
     * has passed. In that case returns an instance of HunterState.
     */
    @Override
    public GhostState returnNextState() {
        if (time >= Constants.getPreyLimitTime()) {
            return new HunterState();
        }
        return this;
    }

    @Override
    public GhostState convertToPrey() {
        return new PreyState();
    }

    @Override
    public GhostState die() {
        return new DeadState();
    }

    @Override
    public GhostState collideWithPacman() {
        return new DeadState();
    }

    @Override
    public String toString() {
        return "presa";
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
        return true;
    }

    @Override
    public boolean isHunter() {
        return false;
    }

}
