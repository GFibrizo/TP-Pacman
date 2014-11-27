package com.grupo2.game;

import com.grupo2.board.Board;
import com.grupo2.board.Board.GameEvent;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.graphicView.ViewsFactory;
import com.grupo2.maze.MazeBuilder;
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
 * @author fibrizo
 */
public class Level {

    private Pacman thePacman;
    private Board map;
    private Controller controller;
    private boolean ended;
    private View view;
    private final Music wakawaka;
    private final Music startLevel;
    private final Music death;
//	private final Music siren;

    /**
     * The constructor of the Level class.
     * @param mazeFilePath
     * @param charactersFilePath
     * @param controller
     * @throws ParserConfigurationException 
     */
    public Level(Path mazeFilePath, Path charactersFilePath, Controller controller) throws ParserConfigurationException {
        MazeBuilder mazeBuilder = new MazeBuilder(mazeFilePath);
        CharacterBuilder charBuilder = new CharacterBuilder(charactersFilePath);
        map = Board.createBoard(mazeBuilder, charBuilder);
        map.subscribeSubscribers();
        map.subscribe(GameEvent.PACMANEATSLITTLEBALL, new ReachLevelEnd(this));
        map.subscribe(GameEvent.PACMANEATSBIGBALL, new ReachLevelEnd(this));
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
        this.startLevel = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "pacman_beginning.wav").toFile());
        this.death = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "pacman_death.wav").toFile());
        map.subscribe(Board.GameEvent.PACMANCOLLIDEHUNTER, new playDeathMusicCommand(this));
    }

    /**
     * The Level is played.
     * @return int score obtained in the level.
     * @throws java.lang.InterruptedException
     */
    public int play() throws InterruptedException {
        this.startLevel.play(true);
        Thread.sleep(4200);
        this.startLevel.stop();
        this.wakawaka.setLoopPositionBySeconds(0.5);
        this.wakawaka.play(true);
//		this.siren.setLoopPositionBySeconds(1);
//		this.siren.play(true);

        while (!ended) {
            map.updateModel(controller);
            map.updateView(this.view);
            if ((!thePacman.hasLives()) && (thePacman.isDead())) {
                ended = true;
            } else if (thePacman.isDead()) {
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.wakawaka.stop();
        return 0;
    }

    /** 
     * @return true if the level is over (i.e. the Pacman has no lives left).
     * returns false otherwise.
     */
    boolean gameover() {
        return !this.thePacman.hasLives();
    }

    
    /*************************************************************************/
    /*************************************************************************/    

    /**
     * Private class of the class Level. It's a Command that has the logic of
     * the things that has to happen when the end of level is reached.
     */
    private class ReachLevelEnd implements Subscriber {

        private Level level;

        public ReachLevelEnd(Level level) {
            this.level = level;
        }

        @Override
        public void execute() {
            this.level.ended = this.level.map.getMaze().isEmpty();
        }
    }


    /*************************************************************************/
    /*************************************************************************/
    
    /**
     * Private class of the class Level. It's a Command that has the logic of
     * the things (related to the music) that has to happen when the Pacman is 
     * dead.
     */
    private class playDeathMusicCommand implements Subscriber {

        private Level level;

        public playDeathMusicCommand(Level level) {
            this.level = level;
        }

        @Override
        public void execute() {
            level.wakawaka.pause();
            level.death.play(true);
            try {
            Thread.sleep(1200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            level.death.stop();
            level.wakawaka.play(true);
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
