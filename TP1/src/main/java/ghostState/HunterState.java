/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ghostState;
import ghost.GhostState;

/**
 *
 * @author fibrizo
 */
public class HunterState extends GhostState {
    
    float time;
    //Velocity here? or in the Rage (ira) classes?
    
    public HunterState() {
        time = 0;
    }
    
    public void move() {
        time++;
    }
    
}
