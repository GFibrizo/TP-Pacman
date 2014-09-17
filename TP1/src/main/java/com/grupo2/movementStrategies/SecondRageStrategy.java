package com.grupo2.movementStrategies;
import com.grupo2.ghostState.RageMovement;

/**
 *
 * @author fibrizo
 */
public class SecondRageStrategy extends HunterStrategy implements RageMovement {

    public SecondRageStrategy() {
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HunterStrategy incrementRage() {
        return new ThirdRageStrategy();
    }

}
