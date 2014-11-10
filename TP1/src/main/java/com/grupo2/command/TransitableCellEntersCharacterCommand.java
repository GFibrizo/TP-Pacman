package com.grupo2.command;

import com.grupo2.balls.NullBall;
import com.grupo2.cell.Cell;

/**
 *
 * @author mauri
 */
public class TransitableCellEntersCharacterCommand extends TransitableCellCommand {

    public TransitableCellEntersCharacterCommand(Cell aCell) {
        if (!aCell.isTransitable())
            throw new ExceptionInInitializerError("Error at command instance: the cell was no transitable");
        this.cell = aCell;
    }

    @Override
    public boolean execute() {
        this.cell.getBall().isEaten();
        this.cell.setBall(new NullBall());
        return true;
    }

}
