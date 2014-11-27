/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.personality;

import com.grupo2.character.Cell;
import com.grupo2.character.Direction;
import com.grupo2.command.HunterStartsChaseOfPacman;
import com.grupo2.constants.Constants;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Personality;
import com.grupo2.pacman.Pacman;
import com.grupo2.maze.MazePublisher;
import com.grupo2.movementStrategies.ChaseStrategy;
import com.grupo2.movementStrategies.RandomStrategy;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class Lazy extends Personality {

    public Lazy() {
        vision = Constants.VISION2;
        Subscriber sub = new HunterStartsChaseOfPacman(this);
        MazePublisher.getInstance().subscribe(MazePublisher.MazeEvent.GHOSTISCLOSETOPACMAN, sub);
        movement = new RandomStrategy();
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
        return "perezoso";
    }

    @Override
    public boolean isDumb() {
        return false;
    }

    @Override
    public boolean isLazy() {
        return true;
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
