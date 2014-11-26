package com.grupo2.balls;

import com.grupo2.board.Board;

/**
 *
 * @author mauri
 */
public class LittleBall implements Ball {

    /**
     * @return int points obtained for eating the littleBall. 
     */
    @Override
    public int isEaten() {
        Board.getInstance().update(Board.GameEvent.PACMANEATSLITTLEBALL);
        return 10;
    }

    /**
     * @return boolean, true because a littleBall is eatable ball
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
        return "bolita";
    }
}
