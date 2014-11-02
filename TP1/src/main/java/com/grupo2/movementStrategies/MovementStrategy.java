package com.grupo2.movementStrategies;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import com.grupo2.character.Direction;
import com.grupo2.directions.*;
import com.grupo2.cell.Cell;
import java.util.Random;

/**
 *
 * @author ivan
 */
public abstract class MovementStrategy {

    protected List<Direction> directions;
    protected Random randomGenerator;

    protected MovementStrategy() {
        directions = new ArrayList<>();
        directions.add(new UpDirection());
        directions.add(new DownDirection());
        directions.add(new LeftDirection());
        directions.add(new RightDirection());
        randomGenerator = new Random();
    }

    public abstract Direction getNewDirection(Map<Direction, Cell> allowedDirections);
}
