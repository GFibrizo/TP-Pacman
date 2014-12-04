package com.grupo2.command;

import com.grupo2.board.Board;
import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author fibrizo
 */
public class PacmanDiesCommand implements Subscriber {

    /**
     * Board on which this command has effect.
     */
    private final Board board;

    /**
     * Constructor.
     *
     * @param board
     */
    public PacmanDiesCommand(final Board board) {
	this.board = board;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	this.board.getPacman().die();
	this.board.getPacman().setCurrentCell(Board.getInstance().getPacmanBegin());
	this.board.setCellForGhosts();
    }

}
