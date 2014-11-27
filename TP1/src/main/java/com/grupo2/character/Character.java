package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.interfaces.Drawable;
import com.grupo2.interfaces.IPositionable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements Drawable, IPositionable {

    //protected Coordinate position;
    protected Direction direction;
    protected Cell currentCell;
    protected float velocity;
    protected Direction previousDirection;
    protected boolean alive;

    protected Character() {
        this.alive = true;
        //this.position = null;
        this.direction = null;
        this.currentCell = null;
        this.velocity = (float) 1.0;
        this.previousDirection = new NullDirection();
    }

    public abstract boolean move();

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
