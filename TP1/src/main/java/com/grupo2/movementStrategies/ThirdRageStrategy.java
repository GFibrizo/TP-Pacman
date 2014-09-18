package com.grupo2.movementStrategies;

import com.grupo2.ghostState.RageMovement;

/**
 *
 * @author fibrizo
 */
public class ThirdRageStrategy extends HunterStrategy implements RageMovement {

	public ThirdRageStrategy() {
	}

	@Override
	public void move() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public HunterStrategy incrementRage() {
		return this;
	}

}
