package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class NullDirection implements Direction {

    @Override
    public boolean canGoForward(Cell cell) {
        return false;
    }

    @Override
	public Cell stepForward(Cell cell) {
		return cell;
    }

    @Override
    public boolean isEqualTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean isEqualTo(RightDirection other) {
        return false;
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
    public boolean EqualTo(Direction other) {
        return false;
    }

    @Override
    public boolean isOposedTo(LeftDirection other) {
        return false;
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
		return "";
	}
}
