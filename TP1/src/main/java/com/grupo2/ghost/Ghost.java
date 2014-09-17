package com.grupo2.ghost;
import com.grupo2.character.IGhost;
import com.grupo2.ghostState.HunterState;
import com.grupo2.character.Character;
import com.grupo2.constants.Constants;
import com.grupo2.ghostState.DeadState;
import com.grupo2.ghostState.PreyState;

/**
 *
 * @author ivan
 */
public class Ghost extends Character implements IGhost {
    
    GhostState state;
    
    /**
     * Create a new instance of the class Ghost in the
     * HunterState.
     * @param x: Position in the X axis
     * @param y: Position in the Y axis
     */
    public Ghost(float x,float y) {
        super(x,y, Constants.getGHOST_RADIUS());
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
     * Changes the actual state of the Ghost for the 
     * state passed as argument.
     * @param aGhostState
     */
    //@Override
    //public void changeState(GhostState aGhostState) {
    //    state = aGhostState;
    //}
    
    
    /**
     * The Ghost is eaten by a Pacman, and acts according 
     * its actual  inner state.
     * The Ghost dies if is in Prey state, and lives if is in Hunter state.
     * If the Ghost is in Dead state, it keeps in that state.
     * @param ghost is the ghost that is colliding with this.
     */
    public void beEaten(Ghost ghost) {
        state.beEaten(ghost);
    }
    
    /**
     * The state turns to dead if the state is Prey, 
     * and keeps the same if the state is Hunter .
     * If the Ghost is in Dead state, it keeps in that state.
     * param pacman is the Pacman that is colliding with this.
     */
    //public abstract void beEaten(Pacman pacman) {
    //    state.beEaten(pacman);
    //}
    
    @Override
    public void die() {
        state = new DeadState();
    }
    
    @Override
    public void convertToPrey() {
        state = new PreyState();
    }
}
