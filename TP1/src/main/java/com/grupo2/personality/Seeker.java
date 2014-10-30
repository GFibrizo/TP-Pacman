/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.personality;

import com.grupo2.character.Direction;
import com.grupo2.ghostState.Personality;
import com.grupo2.constants.Constants;
import com.grupo2.cell.Cell;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class Seeker extends Personality {

    public Seeker() {
        vision = Constants.VISION3;
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beginPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
