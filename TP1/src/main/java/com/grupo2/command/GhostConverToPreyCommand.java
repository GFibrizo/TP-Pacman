/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.command;
import com.grupo2.interfaces.IGhost;
import com.grupo2.map.Map;


/**
 *
 * @author fibrizo
 */
public class GhostConverToPreyCommand extends GhostCommand {
    
    public GhostConverToPreyCommand(IGhost ghost) {
        this.ghost = ghost;
    }
    
    @Override
    public void execute() {
            ghost.convertToPrey();
    }

    @Override
    public void getPublication() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
