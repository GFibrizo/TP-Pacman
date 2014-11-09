/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.fruit;

import com.grupo2.maze.RawMaze;

/**
 *
 * @author mauri
 */
public class Cherry extends Fruit {

    public Cherry(RawMaze maze) {
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
    
}
