package com.grupo2.game;

import com.grupo2.board.Board;
import com.grupo2.board.Board.GameEvent;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.graphicView.ViewsFactory;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.View;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

/**
 *
 * @author
 */
public class Level {

	private final Pacman thePacman;
	private final Board map;
	private final Controller controller;
	private boolean ended;
	private final View view;
	private final Music wakawaka;
//	private final Music siren;

	public Level(Path mazeFilePath, Path charactersFilePath, Controller controller) throws ParserConfigurationException {
		MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(mazeFilePath);
		CharacterBuilder charBuilder = new CharacterXMLBuilder(charactersFilePath);
		this.map = Board.createBoard(mazeBuilder, charBuilder);
		this.map.subscribeSubscribers();
		this.controller = controller;
		thePacman = map.getPacman();
		view = ViewsFactory.createGraphicView(map, controller);
		ended = false;

		this.wakawaka = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "wakawaka.wav").toFile());
		this.wakawaka.setLoopPositionBySeconds(0.5);
//		this.siren = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "siren.wav").toFile());

		this.subscribeToEvents();
	}

	private void subscribeToEvents() {
		map.subscribe(GameEvent.PACMANSTARTMOVING, new MusicPlayer(this.wakawaka));
		map.subscribe(GameEvent.PACMANSTOPMOVING, new MusicPauser(this.wakawaka));
		map.subscribe(GameEvent.PACMANEATSFRUIT, new Subscriber() {
			private final Sound eatFruit;

			{
				this.eatFruit = TinySound.loadSound(Paths.get("src", "main", "resources", "sounds", "eatFruit.wav").toFile());
			}

			@Override
			public boolean execute() {
				this.eatFruit.play();
				return true;
			}
		});
	}

	/**
	 * @return int score obtained in the level.
	 *
	 */
	public int play() {
		while (!ended) {
			map.updateModel(controller);
			map.updateView(this.view);
			if ((!thePacman.hasLives()) && (thePacman.isDead())) {
				ended = true;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

	boolean gameover() {
		return !this.thePacman.hasLives();
	}

	private class ReachLevelEnd implements Subscriber {

		private Level level;

		ReachLevelEnd(Level level) {
			this.level = level;
		}

		@Override
		public boolean execute() {
			this.level.ended = this.level.map.getMaze().isEmpty();
			return true;
		}
	}

	private static class MusicPlayer implements Subscriber {

		private final Music msc;

		public MusicPlayer(Music msc) {
			this.msc = msc;
		}

		@Override
		public boolean execute() {
			if (this.msc.playing()) {
				this.msc.resume();
			} else {
				this.msc.play(true);
			}
			return true;
		}
	}

	private static class MusicPauser implements Subscriber {

		private final Music msc;

		public MusicPauser(Music msc) {
			this.msc = msc;
		}

		@Override
		public boolean execute() {
			this.msc.pause();
			return true;
		}
	}

}
