package com.grupo2.movementStrategies;

import com.grupo2.ghostState.PreyMovement;
import com.grupo2.character.Direction;



/**
 *
 * @author ivan
 */
public class ScapeStrategy extends MovementStrategy implements PreyMovement {

    
    public ScapeStrategy() {
        super();
    }
    
    @Override
    public Direction getNewDirection() {
       return directions.get(randomGenerator.nextInt(3));
    }

}
