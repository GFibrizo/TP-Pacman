package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public interface IGhost extends ICharacter {

	@Override
	public CollidingArea getPosition();

	@Override
	public void move();

	@Override
	public boolean isDead();

	public void die();

	public void convertToPrey();

	public void beEaten(IGhost ghost);

	public boolean isBeingEated(ICharacter someone);
}
