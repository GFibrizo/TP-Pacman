/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TemperamentalSeeker extends Personality {
    
    boolean chaseOn;
    int time = 0;
    int timeIndex = 0;
    float[] arrayOfLimitTimes;
    float limitTime;

    public TemperamentalSeeker() {
        Subscriber sub = new HunterStartsChaseOfPacman(this);
        MazePublisher.getInstance().subscribe(MazePublisher.MazeEvent.GHOSTISCLOSETOPACMAN, sub);
        movement = new ChaseStrategy();
        vision = Constants.VISION4;
        chaseOn = false;
        time = 0;
        timeIndex = 0;
        arrayOfLimitTimes = new float[] {Constants.getFirstRageLimitTime(), Constants.getSecondRageLimitTime(), Constants.getThirdRageLimitTime()};
        limitTime = arrayOfLimitTimes[timeIndex];
    }

    @Override
    public Direction getNewDirection(Map<Direction, Cell> allowedDirections) {
        if (chaseOn) 
            movement.setTarget(Pacman.getPacman().getPosition());
        time++;
        if ((time > limitTime) && (timeIndex < 3)) {
            limitTime = arrayOfLimitTimes[timeIndex++];
            this.incrementVision();
        }
        
        return movement.getNewDirection(allowedDirections);
    }

    @Override
    public void beginPacmanChase() {
        chaseOn = true;
    }

    @Override
    public void stopPacmanChase() {
        movement.setTarget(Pacman.getPacman().getPosition());
        chaseOn = false;
    }

    @Override
    public String toString() {
        return "buscador temperamental";
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
        return false;
    }

    @Override
    public boolean isTemperamentalSeeker() {
        return true;
    }

}
