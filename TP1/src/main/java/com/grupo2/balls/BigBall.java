package com.grupo2.balls;
import com.grupo2.board.Board;
import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import java.util.List;

/**
 *
 * @author mauri
 */
public class BigBall extends Publisher implements Ball {

    @Override
    public int isEaten() {
        Board.getInstance().update(Board.GameEvent.PACMANEATSBALL);
        // INFORMAR EL EVENTO "BOLA GRANDE COMIDA" Y SETEARLE A LA CELDA NULLBALL
        return 30;
    }

    @Override
    public boolean isEatable() {
        return true;
    }

    @Override
    public String toString() {
        return "bolon";
    }

}
