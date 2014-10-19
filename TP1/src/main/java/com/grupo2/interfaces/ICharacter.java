package com.grupo2.interfaces;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public interface ICharacter extends IPositionable {

    public abstract void move();
    public abstract boolean isDead();
    public void changeDirection(Direction theNewDirection);
    public void die();
}
