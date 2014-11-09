package com.grupo2.game;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.InputReader;
import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.view.View;

/**
 *
 * @author mauri
 */
public class Game {

	private MazeBuilder mazeBuilder;
	private InputReader reader;
	private CharacterBuilder charactBuilder;
	private View view;

	public Game(MazeBuilder mazeBuilder, CharacterBuilder charactBuilder, InputReader reader, View view) {
		this.mazeBuilder = mazeBuilder;
		this.reader = reader;
		this.charactBuilder = charactBuilder;
		this.view = view;
	}

    //TODO: Builders should depend on pgm arguments or something like that
    public void startGame() {

		Board map = new Board(this.mazeBuilder, this.charactBuilder);
		Controller controller = new Controller(this.reader);
		this.view.setMaze(map.getMaze());
		this.view.setPacman(map.getPacman());
        map.getGhosts().forEach((IGhost ghost) -> {
			this.view.addGhost(ghost);
        });
        boolean ended = false;

        while (!ended) {
            map.updateModel(controller);
			map.updateView(this.view);
        }
    }
}
