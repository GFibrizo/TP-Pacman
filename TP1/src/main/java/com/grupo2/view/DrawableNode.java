package com.grupo2.view;

import com.grupo2.character.Coordinate;
import com.grupo2.balls.Ball;

/**
 *
 * @author ivan
 */
public interface DrawableNode {

    Coordinate getCoords();

    boolean isEmpty();

    boolean hasLittleBall();

    boolean hasBigBall();
    
    Ball getBall();

    boolean isRightTransitable();

    boolean isLeftTransitable();

    boolean isUpTransitable();

    boolean isDownTransitable();

    public boolean isTransitable();

}
