package com.grupo2.interfaces;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;


/**
 *
 * @author fibrizo
 */
public interface IGhost extends ICharacter {

	public void convertToPrey();
        public void onCollisionWithPacman();
        
}
