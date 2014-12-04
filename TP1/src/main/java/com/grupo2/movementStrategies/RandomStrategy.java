package com.grupo2.movementStrategies;

import com.grupo2.character.Cell;
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

     /**
     * 
     * @param allowedDirections a hash containing the directions that the character can take.
     * @return the new direction that the character will take.
     */
    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        int range = allowedDirections.size();
        if (range > 0) {
            int index = randomGenerator.nextInt(range);
            Direction newDir = (Direction) ((allowedDirections.keySet().toArray())[index]);
            return newDir;
        }
        return new NullDirection();
    }

}
