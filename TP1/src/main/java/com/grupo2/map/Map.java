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
    
    public Map( int height , int width ) {
       // maze = new Maze( height , width );
		// this.maze = new MazeXMLBuilder...
    }
    
    public boolean collisionBetween( ICharacter aCharacter , ICharacter anotherCharacter ) {
        return aCharacter.getPosition().isEqualTo( anotherCharacter.getPosition() );
    }
    
    public void addGhost(IGhost aCharacterToAdd) {
        this.ghosts.add(aCharacterToAdd);
    }
    
    public Pacman getPacman() {
        return this.thePacman;
    }
    
}
