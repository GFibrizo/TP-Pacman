/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.command;

import com.grupo2.interfaces.ICharacter;
import com.grupo2.interfaces.IGhost;
import com.grupo2.map.Map;

/**
 *
 * @author fibrizo
 */
public class PacmanDieCommand extends CharacterCommand {
    public PacmanDieCommand(ICharacter aCharacter) {
        this.character = aCharacter;
    }
    
    @Override
    public void execute() {

    }    

    @Override
    public void getPublication() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
