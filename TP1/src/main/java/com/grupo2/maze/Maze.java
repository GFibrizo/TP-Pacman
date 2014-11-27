package com.grupo2.maze;

import com.grupo2.character.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.character.Positionable;
import com.grupo2.view.DrawableNode;
import com.grupo2.view.DrawableMaze;
import java.util.ArrayList;

/**
 *
 * @author fibrizo
 */
public class Maze implements DrawableMaze {

    /**
     * Matrix containing Cells.
     */
    private ArrayList<ArrayList<Cell>> map;
    private Publisher publisher;
    private int height;
    private int width;
    private Coordinate initPacman;
    private Coordinate initGhost;
    private int nodeWidth;
    private int nodeHeight;
    private int qtyBalls;

    public Maze(final int height, final int width, Coordinate initPacman, Coordinate initGhost) {
        map = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ArrayList<Cell> row = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                row.add(new Cell(j, i, false));
            }
            map.add(row);
        }
        this.height = height;
        this.width = width;
        this.publisher = MazePublisher.getInstance();
        this.initPacman = initPacman;
        this.initGhost = initGhost;
    }

    public void addCell(final Cell newCell) {
        Coordinate pos = newCell.getPosition();
        map.get(pos.getY()).set(pos.getX(), newCell);
        if (newCell.hasBigBall() || newCell.hasLittleBall()) {
            this.qtyBalls++;
        }
    }

    /**
     * Connects each Cell with the adjacent Cells. If the cell is properly
     * initialized is not needed.
     */
    void connectCells() {
        for (ArrayList<Cell> row : this.map) {
            for (Cell cell : row) {
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

    public Coordinate getPacmanBegining() {
        return this.initPacman;
    }

    public void setNodeWidth(int nodeWidth) {
        this.nodeWidth = nodeWidth;
    }

    public void setNodeHeight(int nodeHeight) {
        this.nodeHeight = nodeHeight;
    }

    public Cell getCellFromCoordinates(Coordinate coord) {
        return map.get(coord.getY()).get(coord.getX());
    }

    public boolean areInTheSameCell(Positionable entity, Positionable other) {
        Cell entityCell = entity.getCurrentCell();
        Cell otherCell = other.getCurrentCell();
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
        this.map.stream().forEach((row) -> {
            row.stream().forEach((cell) -> {
                dNodes.add(cell);
            });
        });
        return dNodes;
    }

    public boolean isEmpty() {
        return this.qtyBalls == 0;
    }

    public void ballEated() {
        this.qtyBalls--;
    }

    public Cell getCellFromCoordinates(int x, int y) {
        return map.get(y).get(x);
    }
}
