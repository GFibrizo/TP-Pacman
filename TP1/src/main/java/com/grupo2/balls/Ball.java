package com.grupo2.balls;

/**
 *
 * @author mauri
 */
public interface Ball {

    /**
     * @return int points obtained for eating the ball.
     */
    public int isEaten();

    /**
     * @return boolean, true or false depending of the type of ball. true for
     * LittleBall and BigBall. false for NullBall.
     */
    public boolean isEatable();
}
