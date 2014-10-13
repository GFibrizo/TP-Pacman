/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.command;
import com.grupo2.eventHandling.Command;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public abstract class CharacterCommand implements Command {
    
    protected ICharacter character;
    
}
