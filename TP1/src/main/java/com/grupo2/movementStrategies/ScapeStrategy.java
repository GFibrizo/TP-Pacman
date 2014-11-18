package com.grupo2.movementStrategies;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.directions.NullDirection;
import com.grupo2.pacman.Pacman;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class ScapeStrategy extends RandomStrategy {

    public ScapeStrategy() {
        super();
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        if (allowedDirections.size() == 1) {
            return allowedDirections.keySet().iterator().next();
        }
        
        Coordinate pacmanPosition = Pacman.getPacman().getPosition();
        int maxDistance = pacmanPosition.distanceTo(allowedDirections.values().iterator().next().getPosition());
        Direction chosenDir = new NullDirection();

        for (Map.Entry<Direction, Cell> entry : allowedDirections.entrySet()) {
            int distance = pacmanPosition.distanceTo(entry.getValue().getPosition());
            if (distance > maxDistance) {
                maxDistance = distance;
                chosenDir = entry.getKey();
            }
        }
        return chosenDir;

    }

}
