package com.grupo2.ghost;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.*;
import com.grupo2.ghostState.DeadState;
import com.grupo2.ghostState.Personality;
import com.grupo2.interfaces.IGhost;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {

    private static int counter = 1;
    private GhostState state;
    private Personality personality;
    private Coordinate position;
    private final int id;

    /**
     * Create a new instance of the class Ghost in the HunterState.
     *
     * @param x CollidingArea in the X axis
     * @param y CollidingArea in the Y axis
     * @param dir Initial Direction
     * @param pers Initial personality of the Ghost
     */
    /*public Ghost(final int x, final int y, Direction dir, Personality pers) {
     super(x, y, dir);
     this.state = new HunterState(pers);
     }*/
    private Ghost() {
        super();
        this.velocity = Constants.getInitialVelocity();
        this.id = Ghost.counter;
        Ghost.counter++;
        this.state = null;
    }

    public static Ghost createEmptyGhost() {
        return new Ghost();
    }

    public void setState(GhostState state) {
        this.state = state;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    /**
     * Moves the Ghost in the direction specified and the Ghost behaves
     * according to its actual state.
     */
    @Override
    public void move() {
        //Direction nextDirection;
        if (!direction.isEqualTo(new NullDirection())) {
            previousDirection = direction;
        }
        Map<Direction, Cell> directions = this.allowedDirections();
        if (!state.canMove()) {
            return;
        }
        direction = state.getNewDirection(personality, directions);
        this.currentCell = direction.stepForward(this.currentCell);
        this.position = this.currentCell.getPosition();
        this.state = state.returnNextState();
    }

    /**
     * @return true if the Ghost is dead. False otherwise.
     */
    @Override
    public boolean isDead() {
        return state.isDead();
    }

    @Override
    public void die() {
        this.state = new DeadState();
    }

    @Override
    public void convertToPrey() {
        this.state = state.convertToPrey();
    }

    @Override
    public void onCollisionWithPacman() {
        this.state = state.collideWithPacman(); // Lo bueno de esto es que cuando muere un fantasma, en el constructor del DeadState (por ejemplo) podemos informar al juego y sumar puntos, etc.
    }

    @Override
    public int getVision() {
        return this.personality.getVision();
    }

    public void beginPacmanChase() {
        if (state.testIfAbleToChase()) {
            personality.beginPacmanChase();
        }
    }

    public void stopPacmanChase() {
        if (state.testIfAbleToStopChase()) {
            personality.stopPacmanChase();
        }
    }

    @Override
    public int getNumber() {
        return this.id;
    }

    @Override
    public GhostState getState() {
        return this.state;
    }

    @Override
    public Personality getPersonality() {
        return this.personality;
    }

    public void setInitialPosition(Coordinate coord) {
        this.position = coord;
    }

    public Coordinate getInitialPosition() {
        return this.position;
    }
    
    public boolean isPrey() {
        return this.state.isPrey();
    }
    
    public boolean isHunter() {
        return this.state.isHunter();
    }
    
    public boolean isDumb() {
        return this.personality.isDumb();
    }

    public boolean isLazy() {
        return this.personality.isLazy();
    }
    
    public boolean isSeeker() {
        return this.personality.isSeeker();
    }
    
    public boolean isTemperamentalSeeker() {
        return this.personality.isTemperamentalSeeker();
    }
}
