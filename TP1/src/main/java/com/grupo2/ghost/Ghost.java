package com.grupo2.ghost;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Direction;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
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
    private Cell cell;
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
        this.id = Ghost.counter;
        Ghost.counter++;
        state = null;
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
        Map<Direction, Cell> directions = allowedDirections();
        direction = state.getNewDirection(personality, directions);
        direction.stepForward(this);
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
        if (this.getCurrentCell().canGoUp() && !direction.isOposedTo(new UpDirection())) {
            allowedDirections.put(new UpDirection(), this.getCurrentCell().getUpperCell());
        }
        if (this.getCurrentCell().canGoDown() && !direction.isOposedTo(new DownDirection())) {
            allowedDirections.put(new DownDirection(), this.getCurrentCell().getLowerCell());
        }
        if (this.getCurrentCell().canGoLeft() && !direction.isOposedTo(new LeftDirection())) {
            allowedDirections.put(new LeftDirection(), this.getCurrentCell().getLeftCell());
        }
        if (this.getCurrentCell().canGoRight() && !direction.isOposedTo(new RightDirection())) {
            allowedDirections.put(new RightDirection(), this.getCurrentCell().getRightCell());
        }
        return allowedDirections;

    }

    @Override
    public int getNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GhostState getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personality getPersonality() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
