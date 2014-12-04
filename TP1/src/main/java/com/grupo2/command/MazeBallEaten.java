package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.maze.Maze;

/**
 *
 * @author ivan
 */
public class MazeBallEaten implements Subscriber {

    /**
     * Maze on which this command has effect.
     */
    private final Maze maze;

    /**
     * Constructor.
     *
     * @param maze
     */
    public MazeBallEaten(final Maze maze) {
	this.maze = maze;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	this.maze.ballEated();
    }

}
