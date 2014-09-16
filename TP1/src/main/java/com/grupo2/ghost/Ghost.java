package com.grupo2.ghost;
import com.grupo2.character.IGhost;
import com.grupo2.ghostState.HunterState;
import com.grupo2.character.Character;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {
    
    GhostState state;
    private static final float RADIUS=2;
    
    /**
     * Create a new instance of the class Ghost in the
     * HunterState.
     * @param x: Position in the X axis
     * @param y: Position in the Y axis
     */
    public Ghost(float x,float y) {
        super(x,y,Ghost.RADIUS);
        state = new HunterState();
    }
    
    /**
     * Moves the Ghost in the direction specified and 
     * the Ghost behaves according to its actual state.
     */
    @Override
    public void move(){
        state.move();
        state = state.returnNextState();
    }

    /**
     * @return true if the Ghost is dead. False otherwise.
     */
    @Override
    public boolean isDead() {
        return state.isDead();
    }
    
    /**
     * Change the actual state of the Ghost for the 
     * state passed as argument.
     * @param aGhostState
     */
    @Override
    public void changeState(GhostState aGhostState) {
        state = aGhostState;
    }
    
}
