/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
