package com.grupo2.movementStrategies;
import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
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
            return directions.get(randomGenerator.nextInt(range));
	}



}
