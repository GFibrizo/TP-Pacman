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
	public Ghost(final int x, final int y) {
		super(x, y);
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
        public void chooseDirection() {
            state.move();
        }
        
        public void onCollisionWithPacman() {
            this.state = state.collideWithPacman(); // Lo bueno de esto es que cuando muere un fantasma, en el constructor del DeadState (por ejemplo) podemos informar al juego y sumar puntos, etc.
        }
        
}
