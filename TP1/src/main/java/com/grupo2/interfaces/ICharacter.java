package com.grupo2.interfaces;
import com.grupo2.character.Direction;
import com.grupo2.cell.Cell;

/**
 *
 * @author fibrizo
 */
public interface ICharacter extends IPositionable {

    public abstract void move();
    public abstract boolean isDead();
    public void changeDirection(Direction theNewDirection);
    public void die();
    public void setCurrentCell(Cell cell);
}
