package com.grupo2.balls;

import com.grupo2.board.Board;
import com.grupo2.eventHandling.Publisher;

/**
 *
 * @author mauri
 */
public class BigBall extends Publisher implements Ball {

    /**
     * @return int points obtained for eating the bigBall.
     */
    @Override
    public int isEaten() {
        Board.getInstance().update(Board.GameEvent.PACMANEATSBIGBALL);
        return 30;
    }

    /**
     * @return boolean, true because a BigBall is eatable ball
     */
    @Override
    public boolean isEatable() {
        return true;
    }

    /**
     * @return String, the string that represents the type of the instance.
     */
    @Override
    public String toString() {
        return "bolon";
    }

}
