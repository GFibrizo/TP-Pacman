package com.grupo2.movementStrategies;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.pacman.Pacman;
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
		Cell pacmanCell = Pacman.getPacman().getCurrentCell();
		Coordinate pacmanPosition = null;
		Direction pacmanDirection = Pacman.getPacman().getDirection();

		if (pacmanDirection.EqualTo(new RightDirection())) {
			pacmanPosition = pacmanCell.getRightCell().getPosition();
		} else if (pacmanDirection.EqualTo(new LeftDirection())) {
			pacmanPosition = pacmanCell.getLeftCell().getPosition();
		} else if (pacmanDirection.EqualTo(new UpDirection())) {
			pacmanPosition = pacmanCell.getLowerCell().getPosition();
		} else {
			pacmanPosition = pacmanCell.getUpperCell().getPosition();
		}

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
