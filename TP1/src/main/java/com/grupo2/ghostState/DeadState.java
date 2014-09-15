/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;
import com.grupo2.ghost.GhostState;

/**
 *
 * @author fibrizo
 */
public class DeadState extends GhostState {
    
    @Override
    public void move() {
        // Should move towards the ghost's cage.
    }

    @Override
    public boolean isDead() {
        return true;
    }
    
    
}
