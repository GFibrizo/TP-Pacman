package com.grupo2.pacman;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.directions.NullDirection;

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

	public static Pacman createPacman(final int x, final int y, final Direction dir, Cell begCell) {
		return new Pacman(x, y, dir, begCell);
    }

	private Pacman(final int x, final int y, final Direction dir, Cell currCell) {
        this.position = new Coordinate(x, y);
        this.direction = dir;
        this.nextDirection = new NullDirection();
		this.currentCell = currCell;
        this.alive = true;
    }


    @Override
    public void move() {
		if (this.nextDirection.canGoForward(this.currentCell)) {
            this.direction = this.nextDirection;
            this.nextDirection = new NullDirection();
        }

		if (this.direction.canGoForward(this.currentCell)) {
            this.direction.stepForward(this);
        }
    }


    @Override
    public boolean isDead() {
        return !this.alive;
    }

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


}
