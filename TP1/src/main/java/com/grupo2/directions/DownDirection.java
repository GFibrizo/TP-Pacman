package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class DownDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.getPosition().setY(aCharacter.getPosition().getY() + 1);
    }

    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
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
        return true;
    }

    @Override
    public boolean isOposedTo(Direction other) {
        return (this.EqualTo(other));
    }

    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getLowerCell().isTransitable();
    }    



    
}
