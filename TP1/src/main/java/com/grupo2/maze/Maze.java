/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.maze;

/**
 *
 * @author mauri
 */
public class Maze {
    private static Maze mazeInstance;
    private Maze() {
    }
    public static Maze getInstance() {
        if (mazeInstance == null) {
            mazeInstance = new Maze();
        }
        return mazeInstance;
    }
}
