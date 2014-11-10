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
public class Cherry extends Fruit {

    public Cherry(Maze maze) {
        super(maze);
    }
    
    @Override
    public boolean isDead() {
       //To do
        return true;
    }

    @Override
    public void die() {
        //To do
    }

    @Override
    public void eat() {
        // Add points and dissapear
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
    
}
