package com.grupo2.pacman;

import com.grupo2.character.Cell;
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
	private int score;
	private int lives;

	/**
	 * Class method for getting the unique instance of Pacman.
	 *
	 * @return Pacman the only one.
	 */
	public static Pacman getPacman() {
		if (instance == null) {
			throw new ExceptionInInitializerError("The pacman was not created");
		}
		return instance;
	}

	/**
	 * Class method for creating the Pacman instance.
	 *
	 * @param x       the number of column of the pacman.
	 * @param y       the number of row of the pacman.
	 * @param dir     the direction of the pacman.
	 * @param begCell the current cell of the pacman.
	 * @return Pacman the instance of Pacman.
	 */
	public static Pacman createPacman(final int x, final int y, final Direction dir, Cell begCell) {
		instance = new Pacman(x, y, dir, begCell);
		return instance;
	}

	/**
	 * Private constructor of the Pacman class
	 *
	 * @param x        the number of column of the pacman.
	 * @param y        the number of row of the pacman.
	 * @param dir      the direction of the pacman.
	 * @param currCell
	 */
	private Pacman(final int x, final int y, final Direction dir, Cell currCell) {
		this.direction = dir;
		this.nextDirection = new NullDirection();
		this.currentCell = currCell;
		this.alive = true;
		this.velocity = Constants.getInitialVelocity() * 2;
		this.finishedMovement = 0;
		this.score = 0;
		this.lives = 3;
	}

	/**
	 * This method has all the logic of the pacman movement.
	 */
	@Override
	public boolean move() {
		if (!this.alive) {
			alive = true;
		}
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

		return this.direction.canGoForward(this.currentCell);
	}

	/**
	 * @return boolean true if the pacman is dead, false otherwise.
	 */
	@Override
	public boolean isDead() {
		return !this.alive;
	}

	/**
	 * Set the current cell that is ocuppying the pacman.
	 *
	 * @param currCell
	 */
	@Override
	public void setCurrentCell(Cell currCell) {
		this.currentCell = currCell;
	}

	/**
	 * Set the direction for the movement of the pacman.
	 *
	 * @param direction
	 */
	@Override
	public void setDirection(Direction direction) {
		if (direction != null) {
			this.nextDirection = direction;
		}
	}

	/**
	 * Sets the state of the Pacman to dead.
	 */
	@Override
	public void die() {
		this.alive = false;
		this.lives--;
		this.finishedMovement = 0;
		this.nextDirection = new NullDirection();
	}

	/**
	 * This method returns the score accummulated.
	 *
	 * @return int
	 */
	@Override
	public int getScore() {
		return this.score;
	}

	/**
	 * @return boolean, true if the amount of lifes remaining is higher than 3.
	 */
	@Override
	public boolean hasLives() {
		return (this.lives > 0);
	}

	/**
	 * @return int, the amount of remaining lifes.
	 */
	public int remainingLifes() {
		return this.lives;
	}

	/**
	 * For upcoming refactor.
	 */
	public void eatBall() {
		this.getCurrentCell();
	}

	/**
	 * Increments the scored accummulated with the extra value.
	 *
	 * @param extra
	 */
	public void incrementScore(int extra) {
		this.score += extra;
	}

}
