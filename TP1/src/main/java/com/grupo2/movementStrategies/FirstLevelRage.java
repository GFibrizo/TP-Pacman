package com.grupo2.movementStrategies;

import com.grupo2.ghostState.Rage;

/**
 *
 * @author fibrizo
 */
public class FirstLevelRage extends Rage {

    public FirstLevelRage() {
    }

    @Override
    public Rage incrementRage() {
        return new SecondLevelRage();
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
