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
import com.grupo2.pacman.Pacman;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class Dumb extends Personality {

    public Dumb() {
        // FALTA CORREGIR ESTO
        Subscriber sub = new HunterStartsChaseOfPacman(this);
        MazePublisher.getInstance().subscribe(MazePublisher.MazeEvent.GHOSTISCLOSETOPACMAN, sub);
        movement = new RandomStrategy();
        vision = Constants.VISION1;
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        movement.setTarget(Pacman.getPacman().getPosition());
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
        return "zonzo";
    }

    @Override
    public boolean isDumb() {
        return true;
    }

    @Override
    public boolean isLazy() {
        return false;
    }

    @Override
    public boolean isSeeker() {
        return false;
    }

    @Override
    public boolean isTemperamentalSeeker() {
        return false;
    }

}
