package com.grupo2.pacman;

import com.grupo2.cell.Cell;
import com.grupo2.cell.RawCell;
import com.grupo2.character.Character;
import com.grupo2.character.Direction;
import com.grupo2.directions.NullDirection;
import com.grupo2.constants.Constants;
import com.grupo2.character.Coordinate;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character {

    private Direction nextDirection;
    private boolean alive;
    private int score;

    /*public Pacman(final int x, final int y, final Direction dir) {
        super(x, y, dir);
        this.alive = true;
    }*/
    
    public Pacman(final int x, final int y, final Direction dir) {
        this.position = new Coordinate(x, y);
        this.direction = dir;
        currentCell = null;
        this.alive = true;
    }


    @Override
    public void move() {

        if ( this.nextDirection.canGoForward( (RawCell) currentCell) ) {
            this.direction = this.nextDirection;
            this.nextDirection = new NullDirection();
        }

        if ( this.direction.canGoForward( (RawCell)currentCell) ) {
            this.direction.stepForward(this); 
        }
    }

    
    @Override
    public boolean isDead() {
        return !alive;
    }

    @Override
    public void changeDirection(final Direction theNewDirection) {
        this.direction = theNewDirection;
    }

    @Override
    public void die() {
        alive = false;
    }

}
