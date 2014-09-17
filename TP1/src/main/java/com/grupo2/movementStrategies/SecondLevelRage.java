package com.grupo2.movementStrategies;

import com.grupo2.ghostState.Rage;

/**
 *
 * @author fibrizo
 */
public class SecondLevelRage extends Rage {

    public SecondLevelRage() {
    }

    @Override
    public Rage incrementRage() {
        return new ThirdLevelRage();
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
