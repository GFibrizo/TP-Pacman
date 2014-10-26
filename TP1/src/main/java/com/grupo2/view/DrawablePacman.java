package com.grupo2.view;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;

/**
 *
 * @author ivan
 */
public interface DrawablePacman {

	Coordinate getPosition();

	Direction getDirection();

	int getScore();

	boolean hasLives();
}
