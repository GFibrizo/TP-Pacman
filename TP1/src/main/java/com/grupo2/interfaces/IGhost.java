package com.grupo2.interfaces;

import com.grupo2.character.Coordinate;

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

	public void die();

	public void convertToPrey();

	public void beEaten(IGhost ghost);
        
        public void chooseDirection();

}
