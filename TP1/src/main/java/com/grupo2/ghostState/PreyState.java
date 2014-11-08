package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
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

    private float time = 0;
    private MovementStrategy movement;

    public PreyState() {
        movement = new ScapeStrategy();
    }

    @Override
    public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
        time++;
        return this.movement.getNewDirection(allowedDirections);
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
    
}
