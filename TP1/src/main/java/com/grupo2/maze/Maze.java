package com.grupo2.maze;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.view.DrawableMaze;

/**
 *
 * @author fibrizo
 */
public interface Maze extends DrawableMaze {

	public Coordinate getPacmanBegining();

	public Coordinate getGhostBegining();

	public boolean areInTheSameCell(IPositionable entity, IPositionable other);

	public Cell getCellFromCoordinates(Coordinate coord);

	public boolean isEmpty();

	public void ballEated();

	public Cell getCellFromCoordinates(int x, int y);
}
