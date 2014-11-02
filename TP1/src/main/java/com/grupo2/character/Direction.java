package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;

/**
 *
 * @author mauri
 */
public interface Direction {

    Cell stepForward(Cell cell);

    boolean EqualTo(Direction other);

    boolean isEqualTo(LeftDirection other);

    boolean isEqualTo(RightDirection other);

    boolean isEqualTo(UpDirection other);

    boolean isEqualTo(DownDirection other);

    boolean isOposedTo(LeftDirection other);

    boolean isOposedTo(RightDirection other);

    boolean isOposedTo(UpDirection other);

    boolean isOposedTo(DownDirection other);

	boolean canGoForward(Cell cell);

}
