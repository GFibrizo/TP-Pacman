package com.grupo2.movementStrategies;
import java.util.ArrayList;
import java.util.List;
import com.grupo2.character.Direction;
import com.grupo2.directions.*;
import java.util.Random;

/**
 *
 * @author ivan
 */
public abstract class MovementStrategy {
    
    protected List<Direction> directions;
    Random randomGenerator;
    
    protected MovementStrategy() {
        directions.add(new UpDirection());
        directions.add(new DownDirection());
        directions.add(new LeftDirection());
        directions.add(new RightDirection());
        randomGenerator = new Random();
    }

    public abstract Direction getNewDirection();
}
