package com.grupo2.command;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.pacman.Pacman;

/**
 *
 * @author fibrizo
 */
public class PacmanDiesCommand implements Subscriber {

    Pacman pacman;
    
    public PacmanDiesCommand(Pacman pacman) {
        this.pacman = pacman;
    }

    @Override
    public boolean execute() {
        pacman.die();
        return true;
    }

}
