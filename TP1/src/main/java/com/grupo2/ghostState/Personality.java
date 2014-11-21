package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.movementStrategies.MovementStrategy;
import com.grupo2.constants.Constants;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public abstract class Personality {

    protected int vision;
    protected MovementStrategy movement;

    public abstract Direction getNewDirection(Map<Direction, Cell> allowedDirections);

    public abstract void beginPacmanChase();

    public abstract void stopPacmanChase();

    public int getVision() {
        return vision;
    }
    
    public void incrementVision() {
        vision += Constants.VISION1;
    }

    public abstract boolean isDumb();

    public abstract boolean isLazy();

    public abstract boolean isSeeker();

    public abstract boolean isTemperamentalSeeker();

}
