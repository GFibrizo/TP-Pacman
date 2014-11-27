package com.grupo2.ghostState;

import com.grupo2.ghost.Personality;
import com.grupo2.character.Cell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.GhostState;
import java.util.Map;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {

    float limitTime;
    float[] arrayOfLimitTimes;
    int timeIndex;

    public HunterState() {
        velocity = Constants.getInitialVelocity();
        finishedMovement = 0;
        time = 0;
        timeIndex = 0;
        arrayOfLimitTimes = new float[]{Constants.getFirstRageLimitTime(), Constants.getSecondRageLimitTime(), Constants.getThirdRageLimitTime()};
        limitTime = arrayOfLimitTimes[timeIndex];
    }

    @Override
    public Direction getNewDirection(Personality personality, Map<Direction, Cell> allowedDirections) {
        if ((time > limitTime) && (timeIndex < 3)) {
            limitTime = arrayOfLimitTimes[timeIndex++];
            this.incrementRage();
        }
        time++;
        return personality.getNewDirection(allowedDirections);
    }

    /**
     * @return False, because the State of the Ghost isn't "Dead".
     */
    @Override
    public boolean isDead() {
        return false;
    }

    /**
     * @return the next state of the Ghost. returns this always, since
     * HunterState hasn't a next state.
     */
    @Override
    public GhostState returnNextState() {
        return this;
    }

    @Override
    public GhostState convertToPrey() {
        return new PreyState();
    }

    @Override
    public GhostState die() {
        return this;
    }

    @Override
    public GhostState collideWithPacman() {
        return this;
    }

    public void incrementRage() {
        velocity += Constants.RAGE_BONUS;
    }

    @Override
    public String toString() {
        return "cazador";
    }

    @Override
    public boolean testIfAbleToChase() {
        return true;
    }

    @Override
    public boolean testIfAbleToStopChase() {
        return true;
    }

    @Override
    public boolean isPrey() {
        return false;
    }

    @Override
    public boolean isHunter() {
        return true;
    }
}
