package com.grupo2.balls;

import com.grupo2.board.Board;

/**
 *
 * @author mauri
 */
public class LittleBall implements Ball {

    @Override
    public int isEaten() {
        Board.getInstance().update(Board.GameEvent.PACMANEATSLITTLEBALL);
        //POR AHORA SETEARLE A LA CELDA EN LA QUE ESTÉ LA BOLITA, UNA NULL BALL. LUEGO TAMBIÉN SUMARÁ PUNTOS AL JUEGO.
        return 10;
    }

    @Override
    public boolean isEatable() {
        return true;
    }

    @Override
    public String toString() {
        return "bolita";
    }
}
