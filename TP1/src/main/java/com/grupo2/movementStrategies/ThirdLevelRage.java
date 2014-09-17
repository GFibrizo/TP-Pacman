package com.grupo2.movementStrategies;

import com.grupo2.ghostState.Rage;

/**
 *
 * @author fibrizo
 */
public class ThirdLevelRage extends Rage {

    public ThirdLevelRage() {
    }

    @Override
    public Rage incrementRage() {
        return this;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
