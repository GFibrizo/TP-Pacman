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
import java.util.TreeMap;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {

    private GhostState state;
    private Personality personality;
    private Cell cell;
    /**
     * Create a new instance of the class Ghost in the HunterState.
     *
     * @param x    CollidingArea in the X axis
     * @param y    CollidingArea in the Y axis
     * @param dir  Initial Direction
     * @param pers Initial personality of the Ghost
     */
    /*public Ghost(final int x, final int y, Direction dir, Personality pers) {
            super(x, y, dir);
            this.state = new HunterState(pers);
    }*/

    private Ghost() {
        super();
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
     * Moves the Ghost in the direction specified and the Ghost behaves according to its actual
     * state.
     */
    @Override
    public void move() {
        Direction nextDirection;
        Map<Direction, Cell> directions = allowedDirections();
        if (directions.size() > 1) {
            direction = state.getNewDirection(personality, directions);
        } 
        if (direction.canGoForward(currentCell)) 
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
        
        Map<Direction, Cell> allowedDirections = new TreeMap();        
        
        if( cell.canGoUp() && !direction.isOposedTo(new UpDirection()) ) allowedDirections.put(new UpDirection(), currentCell.getUpperCell());
        if( cell.canGoDown() && !direction.isOposedTo(new DownDirection()) ) allowedDirections.put(new DownDirection(), currentCell.getLowerCell());
        if( cell.canGoLeft() && !direction.isOposedTo(new LeftDirection()) ) allowedDirections.put(new LeftDirection(), currentCell.getLeftCell());
        if( cell.canGoRight() && !direction.isOposedTo(new RightDirection()) ) allowedDirections.put(new RightDirection(), currentCell.getRightCell());        
        return allowedDirections;
        
    }

}
