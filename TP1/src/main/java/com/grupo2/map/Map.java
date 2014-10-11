/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.map;

import com.grupo2.interfaces.ICharacter;
import com.grupo2.maze.Maze;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Map {
    Maze maze;
    ArrayList<ICharacter> characters = new ArrayList<>();
    
    public Map( int height , int width ) {
        maze = new Maze( height , width );
    }
    
    public boolean collisionBetween(ICharacter aCharacter , ICharacter anotherCharacter ) {
        return aCharacter.getPosition().isEqualTo( anotherCharacter.getPosition() );
    }   
    
}
