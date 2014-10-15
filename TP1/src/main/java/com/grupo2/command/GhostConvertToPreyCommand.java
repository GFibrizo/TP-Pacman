package com.grupo2.command;

import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public class GhostConvertToPreyCommand extends GhostCommand {

	GhostConvertToPreyCommand(IGhost ghost) {
		this.ghost = ghost;
	}

	@Override
	public void execute() {
		this.ghost.convertToPrey();
	}

	@Override
	public void getPublication() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
