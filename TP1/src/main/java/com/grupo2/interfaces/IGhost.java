package com.grupo2.interfaces;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public interface IGhost extends ICharacter {

	@Override
	public Coordinate getPosition();

	@Override
	public void move();

	@Override
	public boolean isDead();

        @Override
	public void die();

	public void convertToPrey();
        
        @Override
        public void changeDirection(Direction theNewDirection);

        public void onCollisionWithPacman();
}
