package com.grupo2.character.directions;

import com.grupo2.cell.Cell;
import com.grupo2.cell.RawCell;
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

    @Override
    public boolean canGoForward(RawCell aCell) {
        return aCell.getLowerCell().isTransitable();
    }
    
}
