package com.grupo2.movementStrategies;

import com.grupo2.ghostState.DeadMovement;
import com.grupo2.character.Direction;

/**
 *
 * @author ivan
 */
public class SearchCageStrategy extends MovementStrategy implements DeadMovement {

	public SearchCageStrategy() {
	}

	@Override
	public Direction getNewDirection() {
            throw new UnsupportedOperationException("Not implemented yet");
	}

}
