package com.grupo2.cell;

import com.grupo2.character.Coordinate;

/**
 *
 * @author mauri
 */
public class UntransitableCell extends RawCell {

    private final Coordinate position;
    private RawCell upperCell;
    private RawCell lowerCell;
    private RawCell leftCell;
    private RawCell rightCell;

    public UntransitableCell(int x, int y) {
        this.position = new Coordinate(x, y);
    }

    @Override
    public final boolean isTransitable() {
        return false;
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

    @Override
    public boolean isTheSame(Cell other) {
        // Nothing's gonna be ever in a untransitable cell.
        return false;
    }

    @Override
    public Cell getLeftCell() {
        return this.leftCell;
    }

    @Override
    public Cell getRightCell() {
        return this.rightCell;
    }

    @Override
    public Cell getUpperCell() {
        return this.upperCell;
    }

    @Override
    public Cell getLowerCell() {
        return this.lowerCell;
    }

    @Override
    public boolean canGoUp() {
        return upperCell.isTransitable();
    }

    @Override
    public boolean canGoDown() {
        return lowerCell.isTransitable();
    }

    @Override
    public boolean canGoLeft() {
        return leftCell.isTransitable();
    }

    @Override
    public boolean canGoRight() {
        return rightCell.isTransitable();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Coordinate getCoords() {
        return this.position;
    }

    @Override
    public boolean hasLittleBall() {
        return false;
    }

    @Override
    public boolean hasBigBall() {
        return false;
    }

    @Override
    public boolean isRightTransitable() {
        return this.canGoRight();
    }

    @Override
    public boolean isLeftTransitable() {
        return this.canGoLeft();
    }

    @Override
    public boolean isUpTransitable() {
        return this.canGoUp();
    }

    @Override
    public boolean isDownTransitable() {
        return this.canGoDown();
    }

}
