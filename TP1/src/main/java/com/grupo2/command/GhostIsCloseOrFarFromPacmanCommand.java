package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Ghost;
import com.grupo2.pacman.PacmanArea;

/**
 *
 * @author fibrizo
 */
public class GhostIsCloseOrFarFromPacmanCommand implements Subscriber {

    /**
     * Ghost on which this command has effect.
     */
    private Ghost ghost;

    /**
     * Constructor
     *
     * @param ghost
     */
    public GhostIsCloseOrFarFromPacmanCommand(Ghost ghost) {
	this.ghost = ghost;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	if (PacmanArea.isInside(ghost)) {
	    ghost.beginPacmanChase();
	} else {
	    ghost.stopPacmanChase();
	}
    }

}
