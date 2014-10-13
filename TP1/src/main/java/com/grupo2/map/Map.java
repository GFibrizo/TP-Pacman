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
       // maze = new Maze( height , width );
		// this.maze = new MazeXMLBuilder...
    }
    
    public boolean collisionBetween( ICharacter aCharacter , ICharacter anotherCharacter ) {
        return aCharacter.getPosition().isEqualTo( anotherCharacter.getPosition() );
    }
    
    public void addCharacter(ICharacter aCharacterToAdd) {
        this.characters.add(aCharacterToAdd);
    }
    
}
