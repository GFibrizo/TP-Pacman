package com.grupo2.command;

import com.grupo2.board.Board;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Ghost;

/**
 *
 * @author fibrizo
 */
public class GhostCollidesCommand implements Subscriber {

    /**
     * Ghost on which this command has effect.
     */
    private final Ghost ghost;

    /**
     * Constructor
     *
     * @param ghost
     */
    public GhostCollidesCommand(Ghost ghost) {
	this.ghost = ghost;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	if (Board.getInstance().collisionWithPacman(ghost)) {
	    ghost.onCollisionWithPacman();
	}
    }
}
