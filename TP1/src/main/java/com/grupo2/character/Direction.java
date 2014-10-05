/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character;

/**
 *
 * @author mauri
 */
public interface Direction {
    public abstract Coordinate stepForward(Coordinate currentCoordinate);
}
