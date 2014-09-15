/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public class Coordinate {
    
    int x;
    int y;
    
    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    
    public boolean EqualTo(Coordinate other) {
        if (other == null) return false;
        // Should throw exception. Don't know wich type.
        if (this.x != other.x) return false;
        if (this.y != other.y) return false;
        return true;
    }
   
}
