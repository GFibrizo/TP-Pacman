/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.fruit;

import com.grupo2.maze.Maze;

/**
 *
 * @author mauri
 */
public class NullFruit extends Fruit {

    public NullFruit() {
        this.active = false;
    }

    @Override
    public void die() {
        //To do
    }

    @Override
    public void eat() {
        // Nothins happens
    }

    @Override
    public boolean isDead() {
        return true;
    }

}
