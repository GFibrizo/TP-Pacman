package com.grupo2.fruit;

import com.grupo2.maze.Maze;
import com.grupo2.pacman.Pacman;

/**
 *
 * @author mauri
 */
public class Cherry extends Fruit {

    /**
     * Constructor for the class Cherry.
     *
     * @param maze
     */
    public Cherry(Maze maze) {
	super(maze);
    }

    /**
     * Set the state of the Cherry to dead.
     */
    @Override
    public void die() {
	this.alive = false;
    }

    /**
     * If the cherry is alive increments the score of the Pacman by 100. Also set the Cherry to
     * dead.
     */
    @Override
    public void eat() {
	if (this.alive) {
	    Pacman.getPacman().incrementScore(100);
	}
	this.alive = false;
    }

    /**
     * @return boolean, true if the Cherry is dead, false otherwise.
     */
    @Override
    public boolean isDead() {
	return !this.alive;
    }

}
