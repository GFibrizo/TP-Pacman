package com.grupo2.character.directions;

import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public class LeftDirection implements Direction {

	@Override
	public void stepForward(ICharacter aCharacter) {
		aCharacter.getPosition().setX(aCharacter.getPosition().getX() - 1);
	}
}
