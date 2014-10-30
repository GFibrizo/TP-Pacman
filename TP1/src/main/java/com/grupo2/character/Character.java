package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements ICharacter {

    protected Coordinate position;
    protected Direction direction;
    protected Cell currentCell;

    protected Character() {
        this.position = null;
        this.direction = null;
        currentCell = null;
    }

    @Override
    public abstract void move();

    @Override
    public abstract boolean isDead();

    @Override
    public Coordinate getPosition() {
        return this.currentCell.getPosition();
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public abstract void die();

    @Override
    public void setPosition(Coordinate pos) {
        position = pos;
    }

    @Override
    public void setPosition(int x, int y) {
        position = new Coordinate(x, y);
    }

    @Override
    public void setDirection(Direction dir) {
        direction = dir;
    }

    @Override
    public void setCurrentCell(Cell cell) {
        currentCell = cell;
    }

    @Override
    public Cell getCurrentCell() {
        return this.currentCell;
    }
}
