package com.grupo2.character;

import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements ICharacter {

	protected Coordinate position;

	protected Character(final int x, final int y) {
		this.position = new Coordinate(x, y);
	}

	@Override
	public abstract void move();

	@Override
	public abstract boolean isDead();

	@Override
	public Coordinate getPosition() {
		return position;
	}
}
