package com.grupo2.character;

import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {

	public abstract void stepForward(ICharacter aCharacter);
        public abstract boolean isEqualTo(Direction aDirection);
}
