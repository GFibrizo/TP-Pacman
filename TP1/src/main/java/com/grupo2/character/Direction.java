package com.grupo2.character;

import com.grupo2.cell.Cell;
import com.grupo2.cell.RawCell;
import com.grupo2.character.directions.DownDirection;
import com.grupo2.character.directions.LeftDirection;
import com.grupo2.character.directions.RightDirection;
import com.grupo2.character.directions.UpDirection;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {

	public abstract void stepForward(ICharacter aCharacter);
        public abstract boolean isEqualTo(LeftDirection aDirection);
        public abstract boolean isEqualTo(RightDirection aDirection);
        public abstract boolean isEqualTo(UpDirection aDirection);
        public abstract boolean isEqualTo(DownDirection aDirection);
        public abstract boolean canGoForward(RawCell aCell);
}