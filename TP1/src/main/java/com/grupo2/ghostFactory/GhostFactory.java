/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.ghostFactory;
import com.grupo2.interfaces.IGhost;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghostState.Personality;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class GhostFactory {
    
    public static IGhost createGhost(GhostState state, Personality pers, 
                                            Coordinate coord, Direction dir) {
        Ghost newGhost = Ghost.createEmptyGhost();
        newGhost.setState(state);
        newGhost.setPosition(coord);
        newGhost.setPersonality(pers);
        return newGhost;
    }
    
}
