/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.personality;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghostState.Personality;
import java.util.Map;

/**
 *
 * @author mauri
 */
public class OnlyRight extends Personality {

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        return new RightDirection();
    }

    @Override
    public void beginPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stopPacmanChase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public String toString() {
		return "derechador";
	}

}
