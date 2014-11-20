package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.maze.Maze;

/**
 *
 * @author ivan
 */
public class MazeBallEaten implements Subscriber {

	private Maze maze;

	public MazeBallEaten(Maze maze) {
		this.maze = maze;
	}

	@Override
	public boolean execute() {
		this.maze.ballEated();
		return true;
	}

}
