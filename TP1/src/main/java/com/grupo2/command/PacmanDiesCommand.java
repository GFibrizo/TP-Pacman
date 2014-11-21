package com.grupo2.command;

import com.grupo2.board.Board;
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
    public void execute() {
        pacman.die();
        pacman.setCurrentCell(Board.getInstance().getPacmanBegin());
    }

}
