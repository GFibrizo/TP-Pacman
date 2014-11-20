package com.grupo2.movementStrategies;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class SeekerStrategy extends HunterStrategy {

	public SeekerStrategy() {
	}

	@Override
	public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
