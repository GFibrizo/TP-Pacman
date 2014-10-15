package com.grupo2.command;

import com.grupo2.balls.Ball;

/**
 *
 * @author mauri
 */
public class BallEatenCommand extends BallCommand {

	public BallEatenCommand(Ball aBall) {
		this.ball = aBall ;
	}

	@Override
	public void execute() {
            this.ball.isEaten();
	}

	@Override
	public void getPublication() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
