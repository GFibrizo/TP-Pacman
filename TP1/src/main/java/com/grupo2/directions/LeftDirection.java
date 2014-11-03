package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class LeftDirection implements Direction {

    @Override
	public Cell stepForward(Cell cell) {
		return cell.getLeftCell();
    }

    @Override
    public boolean isEqualTo(LeftDirection aDirection) {
        return true;
    }

    @Override
    public boolean isEqualTo(RightDirection aDirection) {
        return false;
    }

    @Override
    public boolean isEqualTo(UpDirection aDirection) {
        return false;
    }

    @Override
    public boolean isEqualTo(DownDirection aDirection) {
        return false;
    }

    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getLeftCell().isTransitable();
    }

    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
    }

    @Override
    public boolean isOposedTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(RightDirection other) {
        return true;
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
        return "izquierda";
    }

}
