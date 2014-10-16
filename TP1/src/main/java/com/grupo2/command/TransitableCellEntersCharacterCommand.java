package com.grupo2.command;

import com.grupo2.balls.NullBall;
import com.grupo2.cell.TransitableCell;

/**
 *
 * @author mauri
 */
public class TransitableCellEntersCharacterCommand extends TransitableCellCommand {

	public TransitableCellEntersCharacterCommand(TransitableCell aCell) {
		this.cell = aCell;
	}

	@Override
	public void execute() {
            this.cell.getBall().isEaten();
            this.cell.setBall(new NullBall());
        }

}
