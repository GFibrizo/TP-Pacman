package com.grupo2.movementStrategies;

import com.grupo2.ghostState.HunterMovement;
import com.grupo2.character.Direction;

/**
 *
 * @author fibrizo
 */
public class SeekerStrategy extends HunterStrategy implements HunterMovement {

    public SeekerStrategy() {
    }

    @Override
    public Direction getNewDirection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
