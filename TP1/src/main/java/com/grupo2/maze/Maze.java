/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.maze;
import java.util.ArrayList;
import com.grupo2.character.Cell;
import com.grupo2.character.Coordinate;

/**
 *
 * @author fibrizo
 */
public class Maze {
    
    private ArrayList<ArrayList<Cell> > map;
    private int height;
    private int width;
    
    public Maze(int height, int width) {
        map = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ArrayList<Cell> row = new ArrayList<>(width);
            map.add(row);
        }
        this.height = height;
        this.width = width;
    }
    
    public void addCell(Cell newCell) {
        Coordinate pos = newCell.getPosition();
        map.get(pos.getY()).set(pos.getX(), newCell);
    }
    
    
    
    
    
}
