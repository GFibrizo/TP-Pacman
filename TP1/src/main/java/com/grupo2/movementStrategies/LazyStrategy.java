package com.grupo2.movementStrategies;

import com.grupo2.ghostState.HunterMovement;

/**
 *
 * @author fibrizo
 */
public class LazyStrategy extends HunterStrategy implements HunterMovement {

	public LazyStrategy() {
	}

	@Override
	public void move() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public HunterStrategy incrementRage() {
		return new SeekerStrategy();
	}

}
