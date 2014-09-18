package com.grupo2.ghost;

import com.grupo2.interfaces.IGhost;
import com.grupo2.ghostState.HunterState;
import com.grupo2.character.Character;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.constants.Constants;
import com.grupo2.ghostState.DeadState;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {

	private GhostState state;

	/**
	 * Create a new instance of the class Ghost in the HunterState.
	 *
	 * @param x CollidingArea in the X axis
	 * @param y CollidingArea in the Y axis
	 */
	public Ghost(final float x, final float y) {
		super(x, y, Constants.getGhostRadius());
		state = new HunterState();
	}

	/**
	 * Moves the Ghost in the direction specified and the Ghost behaves
	 * according to its actual state.
	 */
	@Override
	public void move() {
		state.move();
		state = state.returnNextState();
	}

	/**
	 * @return true if the Ghost is dead. False otherwise.
	 */
	@Override
	public boolean isDead() {
		return state.isDead();
	}

	@Override
	public void die() {
		state = new DeadState();
	}

	@Override
	public void convertToPrey() {
		state = state.convertToPrey();
	}

	@Override
	public boolean isBeingEated(ICharacter ghost) {
		return this.getPosition().isCollindingWith(ghost.getPosition());
	}

	/*
	 ********Double Dispatch for collisions starts here************
	 */
	/**
	 * The Ghost is eaten by a Pacman, and acts according its actual
	 * inner state:
	 * The Ghost dies if is in Prey state, and lives if is
	 * in HunterState
	 * If the Ghost is in Dead state, it keeps in that state.
	 *
	 * @param ghost is the ghost that is colliding with this.
	 */
	@Override
	public void beEaten(IGhost ghost) {
		state.beEaten(ghost);
	}

	/**
	 * The state turns to dead if the state is Prey, and keeps the same
	 * if the state is Hunter
	 * If the Ghost is in Dead state, it keeps in that state.
	 *
	 * @param pacman is the Pacman that is colliding with this.
	 */
	//public abstract void beEaten(Pacman pacman) {
	//    state.beEaten(pacman);
	//}
}
