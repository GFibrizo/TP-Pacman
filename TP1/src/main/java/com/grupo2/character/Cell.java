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
public interface Cell {
    public boolean isTransitable();
    public Coordinate getPosition();
}