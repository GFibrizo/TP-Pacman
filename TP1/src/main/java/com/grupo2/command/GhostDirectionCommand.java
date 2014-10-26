package com.grupo2.command;

import com.grupo2.ghost.Ghost;

/**
 *
 * @author fibrizo
 */
public class GhostDirectionCommand extends GhostCommand {

	GhostDirectionCommand(Ghost ghost) {
		this.ghost = ghost;
	}

	@Override
	public boolean execute() {
		//no sé si va este command directamente
		return true;
	}

}
