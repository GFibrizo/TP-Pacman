package com.grupo2.character;

import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fibrizo
 */
public abstract class Character implements Positionable {

    /**
     * Characters Direction
     */
    protected Direction direction;
    /**
     * Characters current Cell
     */
    protected Cell currentCell;
    /**
     * Characters velocity
     */
    protected float velocity;
    /**
     * Characters previous Direction
     */
    protected Direction previousDirection;
    /**
     * Characters status
     */
    protected boolean alive;

    /**
     * Protected constructor of the class Character. Used by derivative classes.
     */
    protected Character() {
	this.alive = true;
	this.direction = null;
	this.currentCell = null;
	this.velocity = (float) 1.0;
	this.previousDirection = new NullDirection();
    }

    /**
     * Define the way in that the characters will move, will be overriden.
     *
     * @return true if movement was successfull, false otherwise
     */
    public abstract boolean move();

    /**
     * @return true is the character is dead. False otherwise. Will be overriden.
     */
    public abstract boolean isDead();

    /**
     * @return the current position of the character.
     */
    @Override
    public Coordinate getPosition() {
	return this.currentCell.getPosition();
    }

    /**
     * @return the current direction of the character (of class Direction).
     */
    public Direction getDirection() {
	return this.direction;
    }

    /**
     * In the inherited classes will be defined the logic of the die method.
     */
    public abstract void die();

    /**
     * Sets the current direction.
     *
     * @param dir of type Direction
     */
    public void setDirection(Direction dir) {
	direction = dir;
    }

    /**
     * Sets the current Cell.
     *
     * @param cell of type Cell
     */
    public void setCurrentCell(Cell cell) {
	currentCell = cell;
    }

    /**
     * @return the current Cell.
     */
    @Override
    public Cell getCurrentCell() {
	return this.currentCell;
    }

    /**
     * @return a Map wiht the pair <Direction, Cell> as <key, value>
     * respectively, where the keys are the direction allowed to go, and the values are the Cells
     * related with that direction.
     */
    protected Map<Direction, Cell> allowedDirections() {

	Map<Direction, Cell> allowedDirections = new HashMap();
	if (this.getCurrentCell().canGoUp() && !previousDirection.isOposedTo(new UpDirection())) {
	    allowedDirections.put(new UpDirection(), this.getCurrentCell().getUpperCell());
	}
	if (this.getCurrentCell().canGoDown() && !previousDirection.isOposedTo(new DownDirection())) {
	    allowedDirections.put(new DownDirection(), this.getCurrentCell().getLowerCell());
	}
	if (this.getCurrentCell().canGoLeft() && !previousDirection.isOposedTo(new LeftDirection())) {
	    allowedDirections.put(new LeftDirection(), this.getCurrentCell().getLeftCell());
	}
	if (this.getCurrentCell().canGoRight() && !previousDirection.isOposedTo(new RightDirection())) {
	    allowedDirections.put(new RightDirection(), this.getCurrentCell().getRightCell());
	}
	return allowedDirections;
    }
}
