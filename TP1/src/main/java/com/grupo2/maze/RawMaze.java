package com.grupo2.maze;

import com.grupo2.cell.Cell;
import com.grupo2.cell.RawCell;
import com.grupo2.cell.UntransitableCell;
import com.grupo2.character.Coordinate;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.view.DrawableNode;
import java.util.ArrayList;

/**
 *
 * @author fibrizo
 */
public class RawMaze implements Maze {

    /**
     * Matrix containing Cells.
     */
    private ArrayList<ArrayList<RawCell>> map;
    private Publisher publisher;
    private int height;
    private int width;
    private Coordinate initPacman;
    private Coordinate initGhost;
	private int nodeWidth;
	private int nodeHeight;

    public RawMaze(final int height, final int width, Coordinate initPacman, Coordinate initGhost) {
        map = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ArrayList<RawCell> row = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                row.add(new UntransitableCell(j, i));
            }
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
     * Connects each Cell with the adjacent Cells. If the cell is properly
     * initialized is not needed.
     */
    void connectCells() {
        for (ArrayList<RawCell> row : this.map) {
            for (RawCell cell : row) {
                Coordinate pos = cell.getPosition();
                int x = (pos.getX() - 1 + this.width) % this.width;
                int y = pos.getY();
                cell.setLeftCell(map.get(y).get(x));
                x = (pos.getX() + 1) % this.width;
                cell.setRightCell(map.get(y).get(x));
                x = pos.getX();
                y = (pos.getY() - 1 + this.height) % this.height;
                cell.setUpperCell(map.get(y).get(x));
                y = (pos.getY() + 1) % this.height;
                cell.setLowerCell(map.get(y).get(x));
            }
        }
    }

    @Override
    public Coordinate getPacmanBegining() {
        return this.initPacman;
    }

    @Override
    public Coordinate getGhostBegining() {
        return this.initGhost;
	}

	public void setNodeWidth(int nodeWidth) {
		this.nodeWidth = nodeWidth;
	}

	public void setNodeHeight(int nodeHeight) {
		this.nodeHeight = nodeHeight;
	}

    @Override
    public Cell getCellFromCoordinates(Coordinate coord) {
        // THIS SHOULD CHANGE IN CASE OF CONTINUOUS MOVEMENT
        return map.get(coord.getY()).get(coord.getX());
    }

    @Override
    public boolean areInTheSameCell(IPositionable entity, IPositionable other) {
        Coordinate entityPos = entity.getPosition();
        Coordinate otherPos = other.getPosition();
        Cell entityCell = getCellFromCoordinates(entityPos);
        Cell otherCell = getCellFromCoordinates(otherPos);
        return entityCell.isTheSame(otherCell);
    }

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getNodeWidth() {
		return this.nodeWidth;
	}

	@Override
	public int getNodeHeight() {
		return this.nodeHeight;
	}

	@Override
	public Coordinate getGhostsBegining() {
		return this.initGhost;
	}

	@Override
	public ArrayList<DrawableNode> getNodes() {
		ArrayList<DrawableNode> dNodes = new ArrayList<>();
		for (ArrayList<RawCell> row : this.map) {
			for (RawCell cell : row) {
				dNodes.add(cell);
			}
		}
		return dNodes;
	}
}
