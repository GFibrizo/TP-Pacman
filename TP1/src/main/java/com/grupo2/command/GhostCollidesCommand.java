/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.command;

import com.grupo2.board.Board;
import com.grupo2.ghost.Ghost;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.pacman.Pacman;

/**
 *
 * @author fibrizo
 */
public class GhostCollidesCommand implements Subscriber {

    Ghost ghost;

    public GhostCollidesCommand(Ghost ghost) {
        this.ghost = ghost;
    }

    @Override
    public boolean execute() {
        if (Board.getInstance().collisionWithPacman(ghost)) {
            ghost.onCollisionWithPacman();
        }
        return true;
    }
}
