package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class RightDirection implements Direction {

	@Override
	public Cell stepForward(Cell cell) {
		return cell.getRightCell();
	}

	@Override
	public boolean isEqualTo(LeftDirection other) {
		return false;
	}

	@Override
	public boolean isEqualTo(RightDirection other) {
		return true;
	}

	@Override
	public boolean isEqualTo(UpDirection other) {
		return false;
	}

	@Override
	public boolean isEqualTo(DownDirection other) {
		return false;
	}

	@Override
	public boolean canGoForward(Cell cell) {
		return cell.getRightCell().isTransitable();
	}

	@Override
	public boolean EqualTo(Direction other) {
		return other.isEqualTo(this);
	}

	@Override
	public boolean isOposedTo(LeftDirection other) {
		return true;
	}

	@Override
	public boolean isOposedTo(RightDirection other) {
		return false;
	}

	@Override
	public boolean isOposedTo(UpDirection other) {
		return false;
	}

	@Override
	public boolean isOposedTo(DownDirection other) {
		return false;
	}

	@Override
	public String toString() {
		return "derecha";
	}

}
