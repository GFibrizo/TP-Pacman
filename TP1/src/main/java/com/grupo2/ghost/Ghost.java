package com.grupo2.ghost;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
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
    //private Cell cell;
    private final int id;
    private Direction previousDirection;

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
        this.previousDirection = new NullDirection();
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
        personality.beginPacmanChase();
    }

    public void stopPacmanChase() {
        personality.stopPacmanChase();
    }

    private Map<Direction, Cell> allowedDirections() {

        Map<Direction, Cell> allowedDirections = new HashMap();
        if (this.getCurrentCell().canGoUp() && !previousDirection.isOposedTo(new UpDirection())) {
            allowedDirections.put(new UpDirection(), this.getCurrentCell().getUpperCell());
        }
        if (this.getCurrentCell().canGoDown() && !previousDirection.isOposedTo(new DownDirection())) {
            allowedDirections.put(new DownDirection(), this.getCurrentCell().getLowerCell());
        }
        if (this.getCurrentCell().canGoLeft() && !previousDirection.isOposedTo(new LeftDirection())) {
            allowedDirections.put(new LeftDirection(), this.getCurrentCell().getLeftCell());
        }
        if (this.getCurrentCell().canGoRight() && !previousDirection.isOposedTo(new RightDirection())) {
            allowedDirections.put(new RightDirection(), this.getCurrentCell().getRightCell());
        }
        return allowedDirections;

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

}
