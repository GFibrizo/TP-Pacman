/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character.directions;

import com.grupo2.cell.RawCell;
import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class NullDirection implements Direction {
    
    @Override
    public boolean canGoForward(RawCell aCell) {
        return false;
    }    

    @Override
    public void stepForward(ICharacter aCharacter) {
        //Do nothing
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
        return false;
    }
}
