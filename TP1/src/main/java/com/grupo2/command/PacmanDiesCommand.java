package com.grupo2.command;

import com.grupo2.board.Board;
import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author fibrizo
 */
public class PacmanDiesCommand implements Subscriber {

	Board board;

	public PacmanDiesCommand(Board board) {
		this.board = board;
	}

	@Override
	public void execute() {
		this.board.getPacman().die();
		this.board.getPacman().setCurrentCell(Board.getInstance().getPacmanBegin());
		this.board.setCellForGhosts();
	}

}
