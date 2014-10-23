package com.grupo2.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.cell.Cell;

/**
 *
 * @author mauri
 */
public class RightDirection implements Direction {

    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.setCurrentCell(aCharacter.getCurrentCell().getRightCell());
    }
    
    @Override
    public boolean isEqualTo(LeftDirection other) {
        return false;
    }

    @Override
    public boolean isEqualTo(RightDirection other) {
        return true;
    }

    @Override
    public boolean isEqualTo(UpDirection other) {
        return false;
    }

    @Override
    public boolean isEqualTo(DownDirection other) {
        return false;
    }
    
    @Override
    public boolean canGoForward(Cell cell) {
        return cell.getRightCell().isTransitable();
    }   

    @Override
    public boolean EqualTo(Direction other) {
        return other.isEqualTo(this);
    }
    
    

    @Override
    public boolean isOposedTo(Direction other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
