package com.grupo2.movementStrategies;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.character.Coordinate;
import com.grupo2.pacman.Pacman;
import java.util.Map;
import com.grupo2.directions.NullDirection;

/**
 *
 * @author fibrizo
 */
public class ChaseStrategy extends HunterStrategy {

    public ChaseStrategy() {
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        Coordinate pacmanPosition = Pacman.getPacman().getPosition();
        int minDistance = pacmanPosition.distanceTo(allowedDirections.values().iterator().next().getPosition());
        Direction chosenDir = new NullDirection();

        if (allowedDirections.size() == 1) {
            return allowedDirections.keySet().iterator().next();
        }

        for (Map.Entry<Direction, Cell> entry : allowedDirections.entrySet()) {
            int distance = pacmanPosition.distanceTo(entry.getValue().getPosition());
            if (distance < minDistance) {
                minDistance = distance;
                chosenDir = entry.getKey();
            }
        }
        return chosenDir;

    }

}
