/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character;

import com.grupo2.interfaces.ICharacter;

/**
 *
 * @author mauri
 */
public interface Direction {
    public abstract void stepForward(ICharacter aCharacter);
}
