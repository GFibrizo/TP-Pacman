package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class LeftDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.setCurrentCell(aCharacter.getCurrentCell().getLeftCell());
    }

    @Override
    public boolean isEqualTo(LeftDirection aDirection) {
        return true;
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
        return false;
    }      
    
    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getLeftCell().isTransitable();
    }   


    @Override
    public boolean isOposedTo(Direction other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
    }

    @Override
    public boolean isOposedTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(RightDirection other) {
        return true;
    }

    @Override
    public boolean isOposedTo(UpDirection other) {
        return false;
    }

    @Override
    public boolean isOposedTo(DownDirection other) {
        return false;
    }
    
}
