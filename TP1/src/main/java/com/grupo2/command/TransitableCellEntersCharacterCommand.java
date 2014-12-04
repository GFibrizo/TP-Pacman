package com.grupo2.command;

import com.grupo2.balls.NullBall;
import com.grupo2.character.Cell;

/**
 *
 * @author mauri
 */
public class TransitableCellEntersCharacterCommand {

    private final Cell cell;

    public TransitableCellEntersCharacterCommand(Cell aCell) {
	if (!aCell.isTransitable()) {
	    throw new ExceptionInInitializerError("Error at command instance: the cell was not transitable");
	}
	this.cell = aCell;
    }

    public void execute() {
	this.cell.getBall().isEaten();
	this.cell.setBall(new NullBall());
    }

}
