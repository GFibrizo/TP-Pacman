package com.grupo2.command;

import com.grupo2.ghost.Ghost;
import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author fibrizo
 */
public class GhostConvertToPreyCommand implements Subscriber {

    private Ghost ghost;

    public GhostConvertToPreyCommand(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public void execute() {
        this.ghost.convertToPrey();
    }

}
