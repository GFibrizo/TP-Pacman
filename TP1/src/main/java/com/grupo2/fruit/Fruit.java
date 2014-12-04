package com.grupo2.fruit;

import com.grupo2.character.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.directions.NullDirection;
import com.grupo2.maze.Maze;
import com.grupo2.movementStrategies.RandomStrategy;
import java.util.Random;

/**
 *
 * @author mauri
 */
public abstract class Fruit extends Character {

    private RandomStrategy randomStrategy = new RandomStrategy();

    public Fruit(Maze maze) {
	super();
	this.currentCell = initialCell(maze);
	this.previousDirection = new NullDirection();
	this.direction = this.randomStrategy.getNewDirection(allowedDirections());
	velocity = Constants.getInitialVelocity();
    }

    public Fruit() {
    }

    /**
     * Sets the random initial cell of the Fruit in the Board.
     *
     * @param maze
     * @return Cell, the cell that contains the fruit.
     */
    private Cell initialCell(Maze maze) {
	int height = maze.getHeight();
	int width = maze.getWidth();
	Random random = new Random();
	boolean isTransitable = false;
	Cell aCell = null;
	int x, y;

	while (!isTransitable) {
	    x = random.nextInt(100) % width;
	    y = random.nextInt(100) % height;
	    Coordinate coordinate = new Coordinate(x, y);
	    aCell = maze.getCellFromCoordinates(coordinate);
	    isTransitable = aCell.isTransitable();
	}
	return aCell;
    }

    /**
     * Contains all the logic of the move for the Fruit.
     *
     * @return true (should be if could move or not)
     */
    @Override
    public boolean move() {
	Random random = new Random();
	int randNumber = random.nextInt(10) + 1;

	if (randNumber == 1) {
	    if (!direction.isEqualTo(new NullDirection())) {
		previousDirection = direction;
	    }
	    this.direction = this.randomStrategy.getNewDirection(allowedDirections());
	    this.currentCell = this.direction.stepForward(this.currentCell);
	    return true;
	}
	return false;
    }

    public abstract void eat();

    /**
     * Set to alive the state of the fruit again.
     */
    public void revive() {
	this.alive = true;
    }
}
