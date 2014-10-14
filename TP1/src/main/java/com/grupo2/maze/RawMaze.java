package com.grupo2.maze;

import com.grupo2.character.Coordinate;
import com.grupo2.character.cell.RawCell;
import com.grupo2.eventHandling.Publisher;
import java.util.ArrayList;

/**
 *
 * @author fibrizo
 */
public class RawMaze implements Maze {

	/**
	 * Matrix containing Cells.
	 */
	private final ArrayList<ArrayList<RawCell>> map;
	private final Publisher publisher;
	private final int height;
	private final int width;
	private final Coordinate initPacman;
	private final Coordinate initGhost;

	public RawMaze(final int height, final int width, Coordinate initPacman, Coordinate initGhost) {
		map = new ArrayList<>(height);
		for (int i = 0; i < height; i++) {
			ArrayList<RawCell> row = new ArrayList<>(width);
			map.add(row);
		}
		this.height = height;
		this.width = width;
		this.publisher = MazePublisher.getInstance();
		this.initPacman = initPacman;
		this.initGhost = initGhost;
	}

	public void addCell(final RawCell newCell) {
		Coordinate pos = newCell.getPosition();
		map.get(pos.getY()).set(pos.getX(), newCell);
	}

	/**
	 * Connects each Cell with the adjacent Cells.
	 */
	void connectCells() {
		for (ArrayList<RawCell> row : this.map) {
			for (RawCell cell : row) {
				Coordinate pos = cell.getPosition();
				int x = (pos.getX() - 1) % this.width;
				int y = pos.getY();
				cell.setLeftCell(map.get(y).get(x));
				x = (pos.getX() + 1) % this.width;
				cell.setRightCell(map.get(y).get(x));
				x = pos.getX();
				y = (pos.getY() - 1) % this.height;
				cell.setUpperCell(map.get(y).get(x));
				y = (pos.getY() + 1) % this.height;
				cell.setLowerCell(map.get(y).get(x));
			}
		}
	}

	public Coordinate getPacmanBegining() {
		return this.initPacman;
	}

	public Coordinate getGhostBegining() {
		return this.initGhost;
	}

}
