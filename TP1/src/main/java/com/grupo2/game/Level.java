package com.grupo2.game;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.ghost.Ghost;
import com.grupo2.graphicView.ViewsFactory;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.View;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import kuusisto.tinysound.Music;
import kuusisto.tinysound.TinySound;

/**
 *
 * @author
 */
public class Level {

    private Pacman thePacman;
    private Ghost theGhost;
    private Maze maze;
    private Board map;
    private Controller controller;
    private boolean ended;
    private View view;
    private final Music wakawaka;
    private final Music siren;

    public Level(Path mazeFilePath, Path charactersFilePath, Controller controller) throws ParserConfigurationException {
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(mazeFilePath);
        CharacterBuilder charBuilder = new CharacterXMLBuilder(charactersFilePath);
        map = Board.createBoard(mazeBuilder, charBuilder);
        map.subscribeSubscribers();
        this.controller = controller;
        thePacman = map.getPacman();
        view = ViewsFactory.createGraphicView(map, controller);
        ended = false;

        this.wakawaka = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "wakawaka.wav").toFile());
        this.siren = TinySound.loadMusic(Paths.get("src", "main", "resources", "sounds", "siren.wav").toFile());
    }

    /**
     * @return int score obtained in the level.
     *
     */
    public int play() {
        this.wakawaka.setLoopPositionBySeconds(1);
//		this.wakawaka.play(true);
        this.siren.setLoopPositionBySeconds(1);
//		this.siren.play(true);

        while (!ended) {
            map.updateModel(controller);
            map.updateView(this.view);
            if ((!thePacman.hasLives()) && (thePacman.isDead())) {
                ended = true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
//		this.wakawaka.stop();
        return 0;
    }

}
