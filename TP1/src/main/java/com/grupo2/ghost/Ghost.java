package com.grupo2.ghost;
import com.grupo2.character.IGhost;
import com.grupo2.ghostState.HunterState;

/**
 *
 * @author ivan
 */
public class Ghost implements IGhost {
    
    GhostState state;
    
    public Ghost() {
        state = new HunterState();
    }
    
    @Override
    public void run(){
        // Not implemented. Mock code for TDD
    }
    
    @Override
    public boolean isDead() {
        return this.state.isDead();
    }
    
    @Override
    public void changeState(GhostState aGhostState) {
        this.state = aGhostState;
    }
    
}
