package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public interface IGhost {

	public CollidingArea getPosition();

	public void move();

	public boolean isDead();

	public void die();

	public void convertToPrey();

	public void beEaten(IGhost ghost);

	public boolean isBeingEated(IGhost ghost);
}
