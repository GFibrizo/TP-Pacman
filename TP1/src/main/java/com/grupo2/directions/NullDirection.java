/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.directions;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class NullDirection implements Direction {
    
    @Override
    public boolean canGoForward(Cell cell) {
        return false;
    }    

    @Override
    public void stepForward(ICharacter aCharacter) {
        //Do nothing
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
        return false;
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
