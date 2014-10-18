package com.grupo2.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class DownDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {

        aCharacter.getPosition().setY(aCharacter.getPosition().getY() - 1);
    }

    @Override
    public boolean isEqualTo(Direction other) {
        return other.EqualTo(this);
    }
    
    @Override
    public boolean EqualTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean EqualTo(RightDirection other) {
        return false;
    }

    @Override
    public boolean EqualTo(UpDirection other) {
        return false;
    }

    @Override
    public boolean EqualTo(DownDirection other) {
        return true;
    }

    @Override
    public boolean isOposedTo(Direction other) {
        return (this.isEqualTo(other));
    }

    
}
