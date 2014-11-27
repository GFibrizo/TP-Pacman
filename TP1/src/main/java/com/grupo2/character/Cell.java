package com.grupo2.character;

import com.grupo2.balls.Ball;
import com.grupo2.balls.NullBall;
import com.grupo2.view.DrawableNode;

/**
 *
 * @author mauri
 */
public class Cell implements DrawableNode {

    private Cell upperCell;
    private Cell lowerCell;
    private Cell leftCell;
    private Cell rightCell;
    private Coordinate position;
    private int amountOfWays = 0;
    private Ball ball;
    private boolean isTransitable;

    
    /**
     * Constructor for the class Cell.
     * @param x catersian coordinate x
     * @param y cartesian coordinate y
     * @param isTransitable boolean 
     */
    public Cell(int x, int y, boolean isTransitable) {
        this.position = new Coordinate(x, y);
        this.ball = new NullBall();
        this.isTransitable = isTransitable;
        this.leftCell = null;
        this.lowerCell = null;
        this.rightCell = null;
        this.upperCell = null;
    }

    /**
     * Assigns a Ball instance to the current Cell.
     * @param aBall instance of Ball.
     */
    public void setBall(Ball aBall) {
        if (this.isTransitable) {
            this.ball = aBall;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * @return the Ball that is contained in the current Cell.
     * If the cell is not transitable an exception is thrown.
     */
    @Override
    public Ball getBall() {
        if (this.isTransitable) {
            return this.ball;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * @return True if the cell is transitable. False otherwise.
     */
    @Override
    public boolean isTransitable() {
        return isTransitable;
    }

    /**
     * @return the position of the current cell.
     */
    public Coordinate getPosition() {
        return this.position;
    }

    /**
     * Sets the cell adyacent to the left.
     * @param cell of type Cell
     */
    public void setLeftCell(Cell cell) {
        this.leftCell = cell;
        this.amountOfWays++;
    }

    /**
     * Sets the cell adyacent to the right.
     * @param cell of type Cell
     */
    public void setRightCell(Cell cell) {
        this.rightCell = cell;
        this.amountOfWays++;
    }

    /**
     * Sets the cell down adyacent.
     * @param cell 
     */
    public void setUpperCell(Cell cell) {
        this.upperCell = cell;
        this.amountOfWays++;
    }

    /**
     * Sets the cell up adyacent.
     * @param cell of type Cell
     */
    public void setLowerCell(Cell cell) {
        this.lowerCell = cell;
        this.amountOfWays++;
    }

    /**
     * Check if the cell is the same that the received by parameter.
     * @param other of type Cell
     * @return True if the two cells are the same. False otherwise.
     */
    public boolean isTheSame(Cell other) {
        return position.isEqualTo(other.getPosition());
    }

    /**
     * The ball contained in the current Cell is eated.
     * @return the points received for the eating of the ball.
     */
    public int eatBall() {
        if (!this.isTransitable) {
            throw new UnsupportedOperationException();
        }
        int points = this.ball.isEaten();
        this.ball = new NullBall();
        return points;
    }

    /**
     * @return the cell adyacent to the left.
     */
    public Cell getLeftCell() {
        return this.leftCell;
    }

    /**
     * @return the cell adyacent to the right.
     */    
    public Cell getRightCell() {
        return this.rightCell;
    }

    /**
     * @return the cell up adyacent.
     */
    public Cell getUpperCell() {
        return this.upperCell;
    }
    
    /**
     * @return the cell down ayacent.
     */
    public Cell getLowerCell() {
        return this.lowerCell;
    }

    /**
     * @return true if the upperCell is transitable.
     * false otherwise.
     */
    public boolean canGoUp() {
        return upperCell.isTransitable();
    }

    /**
     * @return true if the lowerCell is transitable.
     * false otherwise.
     */
    public boolean canGoDown() {
        return lowerCell.isTransitable();
    }

    /**
     * @return true if the leftCell is transitable.
     * false otherwise.
     */
    public boolean canGoLeft() {
        return leftCell.isTransitable();
    }

    /**
     * @return true if the rightCell is transitable.
     * false otherwise.
     */
    public boolean canGoRight() {
        return rightCell.isTransitable();
    }

    /**
     * @return true if the ball contained in the cell was eated.
     * false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (!ball.isEatable());
    }

    /**
     * @return the position of the current Cell expresed 
     * using a Coordinate instance.
     */
    @Override
    public Coordinate getCoords() {
        return this.position;
    }
    
    /**
     * @return true if the ball contained is a littleBall. 
     * false otherwise.
     */
    @Override
    public boolean hasLittleBall() {
        return "bolita".equals(String.valueOf(this.ball));
    }

    /**
     * @return true if the ball contained is a bigBall. 
     * false otherwise.
     */
    @Override
    public boolean hasBigBall() {
        return "bolon".equals(String.valueOf(this.ball));
    }
    
    /**
     * @return true if the rightCell is transitable.
     * false otherwise.
     */
    @Override
    public boolean isRightTransitable() {
        return this.canGoRight();
    }
    
    /**
     * @return true if the leftCell is transitable.
     * false otherwise.
     */
    @Override
    public boolean isLeftTransitable() {
        return this.canGoLeft();
    }
    
    /**
     * @return true if the upperCell is transitable.
     * false otherwise.
     */
    @Override
    public boolean isUpTransitable() {
        return this.canGoUp();
    }
    
    /**
     * @return true if the lowerCell is transitable.
     * false otherwise.
     */
    @Override
    public boolean isDownTransitable() {
        return this.canGoDown();
    }

}
