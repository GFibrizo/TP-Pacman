package ghost;
import character.IGhost;
import ghostState.HunterState;

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
        // Not implemented. Mock code for TDD
        return false;
    }
    
}
