package com.grupo2.character.directions;

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
    public boolean isEqualTo(LeftDirection aDirection) {
        return false;
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
        return true;
    }
    
}
