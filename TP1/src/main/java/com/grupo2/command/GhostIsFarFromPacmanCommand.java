/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.command;

import com.grupo2.ghost.Ghost;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.pacman.PacmanArea;

/**
 *
 * @author fibrizo
 */
public class GhostIsFarFromPacmanCommand implements Subscriber {

    private Ghost ghost;

    public GhostIsFarFromPacmanCommand(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public void execute() {
        if (!PacmanArea.isInside(ghost)) {
          //  Subscriber sub = new GhostIsCloseToPacmanCommand(ghost);
           // PacmanArea.getInstance().subscribe(PacmanArea.VisionEvent.GHOST_IS_INSIDE, sub);
            ghost.stopPacmanChase();
        }
    }
}
