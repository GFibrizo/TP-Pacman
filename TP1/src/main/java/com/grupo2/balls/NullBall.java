package com.grupo2.balls;

/**
 *
 * @author ivan
 */
public class NullBall implements Ball {

    @Override
    public int isEaten() {
        return 0;
    }
        
    @Override
    public boolean isEatable() {
        return false;
    }
}
