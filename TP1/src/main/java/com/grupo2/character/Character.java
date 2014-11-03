package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.interfaces.IPositionable;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements IPositionable {

    //protected Coordinate position;
    protected Direction direction;
    protected Cell currentCell;
    protected float velocity;

    protected Character() {
        //this.position = null;
        this.direction = null;
        this.currentCell = null;
		this.velocity = (float) 1.0;
    }

    public abstract void move();

	public abstract boolean isDead();

    @Override
    public Coordinate getPosition() {
        return this.currentCell.getPosition();   
    }

    public Direction getDirection() {
        return this.direction;
    }

    public abstract void die();

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public void setCurrentCell(Cell cell) {
        currentCell = cell;
    }

    @Override
    public Cell getCurrentCell() {
        return this.currentCell;
    }
}
