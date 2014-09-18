package com.grupo2.maze;

/**
 *
 * @author mauri
 */
public class Maze {

	private static Maze mazeInstance;

	private Maze() {
	}

	public static Maze getInstance() {
		if (mazeInstance == null) {
			mazeInstance = new Maze();
		}
		return mazeInstance;
	}

}
