package com.grupo2.game;

import com.grupo2.controller.Controller;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author mauri
 */
public class Game {

    private Controller controller;
    private Level actualLevel;
    private Integer levelIndex;

    public Game(Controller controller) {
        this.controller = controller;
        levelIndex = 0;
    }

    private void startLevel() throws ParserConfigurationException {
        actualLevel = getNextLevel(levelIndex.toString());
    }

    private Level getNextLevel(String index) throws ParserConfigurationException {
        Path mazePath = Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml");
        Path characterPath = Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml");

        //Path mazePath = Paths.get("src", "main", "resources", "Levels", "Level"+ index, "Maze.xml");
        //Path characterPath = Paths.get("src", "main", "resources", "Levels", "Level"+ index, "Characters.xml");
        return new Level(mazePath, characterPath, controller);
    }

    public void play() {
        boolean keepPlaying = true;
        int totalScore = 0;
        try {
            this.startLevel();
        } catch (ParserConfigurationException ex) {
            keepPlaying = false;
        }
        while (keepPlaying) {
            int score = actualLevel.play();
            //if (!showContinueToNextLevel(score)) break;
            levelIndex++;
            try {
                this.startLevel();
            } catch (ParserConfigurationException ex) {
                keepPlaying = false;
            }
            totalScore += score;
        }
        //showEndGame(totalScore);
    }

}
