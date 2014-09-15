/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;
import com.grupo2.ghost.GhostState;
import com.grupo2.rage.FirstLevelRage;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {
    
    float time;
    Rage rage;
    //Velocity here? or in the Rage (ira) classes?
    
    public HunterState() {
        time = 0;
        rage = new FirstLevelRage();
    }
    
    @Override
    public void move() {
        time++;
    }
    
    @Override
    public boolean isDead() {
        return false;
    }
    
    @Override
    public GhostState returnNextState() {
        return this;
    }
}
