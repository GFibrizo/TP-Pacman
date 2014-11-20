package com.grupo2.personality;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.command.HunterStartsChaseOfPacman;
import com.grupo2.constants.Constants;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghostState.Personality;
import com.grupo2.maze.MazePublisher;
import com.grupo2.movementStrategies.ChaseStrategy;
import com.grupo2.movementStrategies.RandomStrategy;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class Seeker extends Personality {

    public Seeker() {
        Subscriber sub = new HunterStartsChaseOfPacman(this);
        MazePublisher.getInstance().subscribe(MazePublisher.MazeEvent.GHOSTISCLOSETOPACMAN, sub);
        movement = new RandomStrategy();
        vision = Constants.VISION3;
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        return movement.getNewDirection(allowedDirections);
    }

    @Override
    public void beginPacmanChase() {
        this.movement = new ChaseStrategy();
    }

    @Override
    public void stopPacmanChase() {
        this.movement = new RandomStrategy();
    }

    @Override
    public String toString() {
        return "buscador";
    }

    @Override
    public boolean isDumb() {
        return false;
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public boolean isSeeker() {
        return true;
    }

    @Override
    public boolean isTemperamentalSeeker() {
        return false;
    }

}
