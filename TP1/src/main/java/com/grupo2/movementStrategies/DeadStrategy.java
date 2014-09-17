package com.grupo2.movementStrategies;
import com.grupo2.ghostState.DeadMovement;

/**
 *
 * @author ivan
 */
public class DeadStrategy extends MovementStrategy implements DeadMovement {

    public DeadStrategy() {
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
