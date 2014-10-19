package com.grupo2.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.cell.Cell;

/**
 *
 * @author mauri
 */
public class UpDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.getPosition().setY(aCharacter.getPosition().getY() + 1);
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
        return true;
    }

    @Override
    public boolean isEqualTo(DownDirection aDirection) {
        return false;
    }
    
    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getUpperCell().isTransitable();
    }   

    @Override
    public boolean EqualTo(Direction other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOposedTo(Direction other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
