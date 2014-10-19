package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {

	void stepForward(ICharacter aCharacter);

	boolean isEqualTo(Direction otherDir);

	boolean isEqualTo(LeftDirection aDirection);

	boolean isEqualTo(RightDirection aDirection);

	boolean isEqualTo(UpDirection aDirection);

	boolean isEqualTo(DownDirection aDirection);

	boolean canGoForward(Cell aCell);

	boolean isOposedTo(Direction other);

}
