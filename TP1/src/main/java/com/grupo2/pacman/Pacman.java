package com.grupo2.pacman;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.NullDirection;
import com.grupo2.view.DrawablePacman;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character implements DrawablePacman {

    private static Pacman instance;
    private float finishedMovement;
    private Direction nextDirection;
    private boolean alive;
    private int score;

    /*public Pacman(final int x, final int y, final Direction dir) {
     super(x, y, dir);
     this.alive = true;
     }*/
    public static Pacman getPacman() {
        if (instance == null) {
            throw new ExceptionInInitializerError();
        }
        return instance;
    }

    public static Pacman createPacman(final int x, final int y, final Direction dir, Cell begCell) {
        instance = new Pacman(x, y, dir, begCell);
        return instance;
    }

    private Pacman(final int x, final int y, final Direction dir, Cell currCell) {
        this.direction = dir;
        this.nextDirection = new NullDirection();
        this.currentCell = currCell;
        this.alive = true;
        this.velocity = Constants.getInitialVelocity() * 2;
        this.finishedMovement = 0;
    }

    @Override
    public void move() {
        if (this.nextDirection.canGoForward(this.currentCell)) {
            this.direction = this.nextDirection;
            this.nextDirection = new NullDirection();
        }

        finishedMovement += velocity;

        if (this.direction.canGoForward(this.currentCell)) {
            if (finishedMovement >= 1) {
                this.currentCell = this.direction.stepForward(this.currentCell);
                finishedMovement -= 1;
            }
        }
    }

    @Override
    public boolean isDead() {
        return !this.alive;
    }

    @Override
    public void setCurrentCell(Cell currCell) {
        this.currentCell = currCell;
    }

    @Override
    public void setDirection(Direction direction) {
        this.nextDirection = direction;
    }

    @Override
    public void die() {
        this.alive = false;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public boolean hasLives() {
        return !this.isDead();
    }

}
