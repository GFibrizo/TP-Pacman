package com.grupo2.movementStrategies;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class RandomStrategy extends MovementStrategy {

	public RandomStrategy() {
            super();
	}

	@Override
	public Direction getNewDirection() {
            return directions.get(randomGenerator.nextInt(4));
	}



}
