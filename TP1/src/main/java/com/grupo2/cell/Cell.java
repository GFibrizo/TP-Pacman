package com.grupo2.cell;

import com.grupo2.balls.Ball;
import com.grupo2.balls.NullBall;
import com.grupo2.character.Collitionable;
import com.grupo2.character.Coordinate;
import com.grupo2.view.DrawableNode;

/**
 *
 * @author mauri
 */
public class Cell implements DrawableNode {

    private Collitionable content;
    private Cell upperCell;
    private Cell lowerCell;
    private Cell leftCell;
    private Cell rightCell;
    private Coordinate position;
    private int amountOfWays = 0;
    private Ball ball;
    private boolean isTransitable;

    public Cell(int x, int y, boolean isTransitable) {
        this.position = new Coordinate(x, y);
        this.content = null;
        this.ball = new NullBall();
        this.isTransitable = isTransitable;
        this.leftCell = null;
        this.lowerCell = null;
        this.rightCell = null;
        this.upperCell = null;
    }

    public void setBall(Ball aBall) {
        if (this.isTransitable) {
            this.ball = aBall;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Ball getBall() {
        if (this.isTransitable) {
            return this.ball;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean isTransitable() {
        return isTransitable;
    }

    public Collitionable getContent() {
        if (this.isTransitable) {
            return this.content;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public Coordinate getPosition() {
        return this.position;
    }

    public void setLeftCell(Cell cell) {
        this.leftCell = cell;
        this.amountOfWays++;
    }

    public void setRightCell(Cell cell) {
        this.rightCell = cell;
        this.amountOfWays++;
    }

    public void setUpperCell(Cell cell) {
        this.upperCell = cell;
        this.amountOfWays++;
    }

    public void setLowerCell(Cell cell) {
        this.lowerCell = cell;
        this.amountOfWays++;
    }

    public void setContent(Collitionable newContent) {
        this.content = newContent;
    }

    public boolean isTheSame(Cell other) {
        return position.isEqualTo(other.getPosition());
    }

    public int eatBall() {
        if (!this.isTransitable) {
            throw new UnsupportedOperationException();
        }
        int points = this.ball.isEaten();
        this.ball = new NullBall();
        return points;
    }

    public Cell getLeftCell() {
        return this.leftCell;
    }

    public Cell getRightCell() {
        return this.rightCell;
    }

    public Cell getUpperCell() {
        return this.upperCell;
    }

    public Cell getLowerCell() {
        return this.lowerCell;
    }

    public boolean canGoUp() {
        return upperCell.isTransitable();
    }

    public boolean canGoDown() {
        return lowerCell.isTransitable();
    }

    public boolean canGoLeft() {
        return leftCell.isTransitable();
    }

    public boolean canGoRight() {
        return rightCell.isTransitable();
    }

    public boolean isEmpty() {
        /*if (!isTransitable) {
            throw new UnsupportedOperationException();
        }*/
        return (!ball.isEatable());
    }

    public Coordinate getCoords() {
        return this.position;
    }

    public boolean hasLittleBall() {
        // PEDORRISIMO
        return "bolita".equals(String.valueOf(this.ball));
    }

    public boolean hasBigBall() {
        // PEDORRISIMO
        return "bolon".equals(String.valueOf(this.ball));
    }

    public boolean isRightTransitable() {
        return this.canGoRight();
    }

    public boolean isLeftTransitable() {
        return this.canGoLeft();
    }

    public boolean isUpTransitable() {
        return this.canGoUp();
    }

    public boolean isDownTransitable() {
        return this.canGoDown();
    }

}
