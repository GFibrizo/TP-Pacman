package com.grupo2.pacman;

import com.grupo2.cell.RawCell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Character;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.NullDirection;
import java.lang.ExceptionInInitializerError;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character {

    
    private static Pacman instance;
    
    private Direction nextDirection;
    private boolean alive;
    private int score;

    /*public Pacman(final int x, final int y, final Direction dir) {
        super(x, y, dir);
        this.alive = true;
    }*/
    
    public static Pacman getPacman() {
        if (instance == null) 
            throw new ExceptionInInitializerError();
        return instance;
    }
    
    public static Pacman createPacman(final int x, final int y, final Direction dir) {
        return new Pacman(x, y, dir);
    }
    
    private Pacman(final int x, final int y, final Direction dir) {
        this.position = new Coordinate(x, y);
        this.direction = dir;
        this.nextDirection = new NullDirection();
        this.currentCell = null;
        this.alive = true;
    }


    @Override
    public void move() {
        if ( this.nextDirection.canGoForward(currentCell) ) {
            this.direction = this.nextDirection;
            this.nextDirection = new NullDirection();
        }

        if ( this.direction.canGoForward(currentCell) ) {
            this.direction.stepForward(this); 
        }
    }

    
    @Override
    public boolean isDead() {
        return !alive;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void die() {
        alive = false;
    }

}
