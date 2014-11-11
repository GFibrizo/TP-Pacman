package com.grupo2.view;

import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public abstract class View {

	protected DrawableMaze maze;
	protected DrawablePacman pacman;
	protected ArrayList<DrawableGhost> ghosts;

	public View() {
		this.ghosts = new ArrayList<>();
	}

	public void setPacman(DrawablePacman pacman) {
		this.pacman = pacman;
	}

	public void addGhost(DrawableGhost ghost) {
		this.ghosts.add(ghost);
	}

	public void setMaze(DrawableMaze maze) {
		this.maze = maze;
	}

	public abstract void show();
}
