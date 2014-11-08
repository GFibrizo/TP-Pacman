package com.grupo2.movementStrategies;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.directions.NullDirection;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class RandomStrategy extends MovementStrategy {

    public RandomStrategy() {
        super();
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        int range = allowedDirections.size();
        if (range > 0) {
            int index = randomGenerator.nextInt(range);
            Direction newDir = (Direction)((allowedDirections.keySet().toArray())[index]);
            return newDir;
        }
        return new NullDirection();
    }

}
