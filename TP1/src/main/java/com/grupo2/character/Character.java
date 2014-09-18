package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public abstract class Character implements ICharacter{

	CollidingArea position;

	protected Character(float x, float y, float radius) {
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
