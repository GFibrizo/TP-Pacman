package com.grupo2.character;

import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements ICharacter {

	protected CollidingArea position;

	protected Character(final float x, final float y, final float radius) {
		this.position = new CollidingArea(x, y, radius);
	}

	@Override
	public abstract void move();

	@Override
	public abstract boolean isDead();

	@Override
	public CollidingArea getPosition() {
		return position;
	}
}
