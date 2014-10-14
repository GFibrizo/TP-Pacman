package com.grupo2.cell;

import com.grupo2.character.Collitionable;
import com.grupo2.character.Coordinate;
import com.grupo2.balls.Ball;

/**
 *
 * @author mauri
 */
public class TransitableCell implements RawCell {

    private Collitionable content;
    private Cell upperCell;
    private Cell lowerCell;
    private Cell leftCell;
    private Cell rightCell;
    private Coordinate position;
    private Ball ball;

    public TransitableCell(int x, int y) {
            this.position = new Coordinate(x, y);
    }

    public void setBall(Ball aBall) {
            this.ball = aBall;
    }

    public Ball getBall() {
            return this.ball;
    }

    @Override
    public boolean isTransitable() {
            return true;
    }

    public Collitionable getContent() {
            return this.content;
    }

    @Override
    public Coordinate getPosition() {
            return this.position;
    }

    @Override
    public void setLeftCell(RawCell rc) {
            this.leftCell = rc;
    }

    @Override
    public void setRightCell(RawCell rc) {
            this.rightCell = rc;
    }

    @Override
    public void setUpperCell(RawCell rc) {
            this.upperCell = rc;
    }

    @Override
    public void setLowerCell(RawCell rc) {
            this.lowerCell = rc;
    }


    public void setContent(Collitionable c) {
            this.content = c;
    }

    @Override
    public boolean isTheSame(Cell other) {
        return position == other.getPosition();
    }

}
