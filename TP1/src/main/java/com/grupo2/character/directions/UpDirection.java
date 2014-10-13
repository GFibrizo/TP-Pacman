/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character.directions;
import com.grupo2.character.Direction;
import com.grupo2.interfaces.ICharacter;
/**
 *
 * @author mauri
 */
public class UpDirection implements Direction {
    
    @Override
    public void stepForward(ICharacter aCharacter) {
        aCharacter.getPosition().setY(aCharacter.getPosition().getY()+1);
    }
}
