/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.pacman;
import com.grupo2.interfaces.IGhost;


/**
 *
 * @author fibrizo
 */
public class PacmanArea {
    
    int xCenter;
    int yCenter;
    
    public PacmanArea() {
    }
    
    public void CenterAreaOnPacman(Pacman pacman) {
        xCenter = pacman.getPosition().getX();
        yCenter = pacman.getPosition().getY();
    }
    
    private void isInXRange() {
        return (x > xCenter - )
    }
    
    public void isInside(IGhost ghost) {
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        int vision = ghost.getVision();
        
    }
    
}
