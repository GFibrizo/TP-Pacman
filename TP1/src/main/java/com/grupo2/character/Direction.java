package com.grupo2.character;

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

    public abstract void stepForward(ICharacter other);
    public abstract boolean isEqualTo(Direction other);
    public abstract boolean EqualTo(LeftDirection other);
    public abstract boolean EqualTo(RightDirection other);
    public abstract boolean EqualTo(UpDirection other);
    public abstract boolean EqualTo(DownDirection other);
    public abstract boolean isOposedTo(Direction other);
        
}