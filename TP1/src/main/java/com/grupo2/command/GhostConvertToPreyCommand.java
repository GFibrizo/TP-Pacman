package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Ghost;

/**
 *
 * @author fibrizo
 */
public class GhostConvertToPreyCommand implements Subscriber {

    /**
     * Ghost on which this command has effect.
     */
    private Ghost ghost;

    /**
     * Constructor
     *
     * @param ghost
     */
    public GhostConvertToPreyCommand(Ghost ghost) {
	this.ghost = ghost;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	this.ghost.convertToPrey();
    }

}
