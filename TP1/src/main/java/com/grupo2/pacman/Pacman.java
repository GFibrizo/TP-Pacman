package com.grupo2.pacman;

import com.grupo2.character.Character;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character {

	private Direction nextDirection;
	private Direction currdirection;
	private boolean alive;

	public Pacman(final int x, final int y, final Direction dir) {
		super(x, y, dir);
		this.alive = true;
	}

	@Override
	public void move() {
		this.currdirection.stepForward(this);
	}

	@Override
	public boolean isDead() {
		return alive;
	}

	@Override
	public void changeDirection(final Direction theNewDirection) {
		this.currdirection = theNewDirection;
	}

}
