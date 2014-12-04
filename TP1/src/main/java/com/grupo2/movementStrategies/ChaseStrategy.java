package com.grupo2.movementStrategies;

import com.grupo2.character.Cell;
import com.grupo2.character.Direction;
import java.util.Map;
import com.grupo2.directions.NullDirection;

/**
 *
 * @author fibrizo
 */
public class ChaseStrategy extends MovementStrategy {

    public ChaseStrategy() {
        target = null;
    }

    /**
     * 
     * @param allowedDirections a hash containing the directions that the character can take.
     * @return the new direction that the character will take.
     */
    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {

        int minDistance = target.distanceTo(allowedDirections.values().iterator().next().getPosition());
        Direction chosenDir = new NullDirection();

        if (allowedDirections.size() == 1) {
            return allowedDirections.keySet().iterator().next();
        }

        for (Map.Entry<Direction, Cell> entry : allowedDirections.entrySet()) {
            int distance = target.distanceTo(entry.getValue().getPosition());
            if (distance < minDistance) {
                minDistance = distance;
                chosenDir = entry.getKey();
            }
        }
        return chosenDir;

    }

}
