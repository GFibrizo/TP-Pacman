/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.command;

import com.grupo2.board.Board;
import com.grupo2.ghost.Ghost;
import com.grupo2.eventHandling.Subscriber;

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
    public void execute() {
        if (Board.getInstance().collisionWithPacman(ghost)) {
            ghost.onCollisionWithPacman();
        }
    }
}
