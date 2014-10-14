package com.grupo2.command;

import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public class GhostDirectionCommand extends GhostCommand {

	GhostDirectionCommand(IGhost ghost) {
		this.ghost = ghost;
	}

	@Override
	public void execute() {
		//no sé si va este command directamente
	}

	@Override
	public void getPublication() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
