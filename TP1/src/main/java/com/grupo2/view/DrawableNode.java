package com.grupo2.view;

import com.grupo2.character.Coordinate;

/**
 *
 * @author ivan
 */
public interface DrawableNode {

	Coordinate getCoords();

	boolean isEmpty();

	boolean hasLittleBall();

	boolean hasBigBall();

	boolean isRightTransitable();

	boolean isLeftTransitable();

	boolean isUpTransitable();

	boolean isDownTransitable();

}
