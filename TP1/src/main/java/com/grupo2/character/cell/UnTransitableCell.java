/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character.cell;

import com.grupo2.character.Coordinate;

/**
 *
 * @author mauri
 */
public class UnTransitableCell {
    
    private Coordinate position;
    
    public UnTransitableCell(Coordinate position) {
        this.position = position;
    }
    
    public boolean isTransitable() {
        return false;
    }
}
