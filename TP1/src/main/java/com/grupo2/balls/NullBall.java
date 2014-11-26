package com.grupo2.balls;

/**
 *
 * @author ivan
 */
public class NullBall implements Ball {

    /**
     * @return int points obtained for eating the nullBall, that is cero. 
     */
    @Override
    public int isEaten() {
        return 0;
    }

    /**
     * @return boolean, false because a NullBall is eatable ball
     */
    @Override
    public boolean isEatable() {
        return false;
    }
}
