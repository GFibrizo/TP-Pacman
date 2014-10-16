package com.grupo2.character.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class DownDirection implements Direction {

	@Override
	public void stepForward(ICharacter aCharacter) {
		aCharacter.getPosition().setY(aCharacter.getPosition().getY() - 1);
	}
        
        public boolean sameDirection(Direction anotherD) {
            return false;
        }
        
        public boolean sameDirection(LeftDirection leftD) {
            return true;
        }
}
