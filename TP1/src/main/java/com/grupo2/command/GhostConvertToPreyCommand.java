package com.grupo2.command;

import com.grupo2.ghost.Ghost;

/**
 *
 * @author fibrizo
 */
public class GhostConvertToPreyCommand extends GhostCommand {

    public GhostConvertToPreyCommand(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public boolean execute() {
        this.ghost.convertToPrey();
        return true;
    }

}
