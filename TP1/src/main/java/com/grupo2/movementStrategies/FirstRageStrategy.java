package com.grupo2.movementStrategies;

import com.grupo2.ghostState.RageMovement;

/**
 *
 * @author fibrizo
 */
public class FirstRageStrategy extends HunterStrategy implements RageMovement {

	public FirstRageStrategy() {
	}

	@Override
	public void move() {
            
            throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public HunterStrategy incrementRage() {
		return new SecondRageStrategy();
	}

}
