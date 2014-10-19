package com.grupo2.character;


import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.cell.Cell;


import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {

    public abstract void stepForward(ICharacter other);
    public abstract boolean EqualTo(Direction other);
    public abstract boolean isEqualTo(LeftDirection other);
    public abstract boolean isEqualTo(RightDirection other);
    public abstract boolean isEqualTo(UpDirection other);
    public abstract boolean isEqualTo(DownDirection other);
    public abstract boolean isOposedTo(Direction other);
    public abstract boolean canGoForward(Cell cell);

}
