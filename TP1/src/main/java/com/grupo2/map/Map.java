package com.grupo2.map;

import com.grupo2.interfaces.ICharacter;
import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.Maze;
import com.grupo2.pacman.Pacman;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Map {
    Maze maze;
    ArrayList<IGhost> ghosts = new ArrayList<>();
    Pacman thePacman = new Pacman(0,0);
    private static Map mapSingleton;
    
    private Map() {
       // maze = new Maze( height , width );
		// this.maze = new MazeXMLBuilder...
    }
    
    public boolean collisionBetween( ICharacter aCharacter , ICharacter anotherCharacter ) {
        return aCharacter.getPosition().isEqualTo( anotherCharacter.getPosition() );
    }
    
    public boolean collisionWithPacman( ICharacter anotherCharacter ) {
        return thePacman.getPosition().isEqualTo( anotherCharacter.getPosition() );
    }
    
    public void addGhost(IGhost aCharacterToAdd) {
        this.ghosts.add(aCharacterToAdd);
    }
    
    public Pacman getPacman() {
        return this.thePacman;
    }
    
    public static Map getInstance() {
        if ( mapSingleton == null ) {
            mapSingleton = new Map();
        }
        return mapSingleton;
        }    
}
