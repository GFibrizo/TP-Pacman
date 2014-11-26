package com.grupo2.game;

import com.grupo2.controller.Controller;
import com.grupo2.constants.Constants;
import com.grupo2.graphicView.ViewsFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author mauri
 */
public class Game {

    private Controller controller;
    private Level actualLevel;
    private int levelIndex;
    private int qtyLevels;

    /**
     * The constructor of the class Game
     * @param controller of the type Controller. That controls the Pacman movements.
     * @throws InterruptedException 
     */
    public Game(Controller controller) throws InterruptedException {
        this.controller = controller;
        this.levelIndex = 0;
        this.qtyLevels = 0;
        try {
            Files.walk(Paths.get("src", "main", "resources", "Levels")).forEachOrdered(levelFile -> {
                if (levelFile.toString().matches(".*MazeLevel[0-9]+.xml")) {
                    this.qtyLevels++;
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        Constants.initializeConstants(Paths.get("src", "main", "resources", "Constants.json"));
        ViewsFactory.createStartGame();
    }

    /**
     * Starts the next level. In case of being at the begginig of the game, the
     * next level is the first.
     * @throws ParserConfigurationException 
     */
    private void startLevel() throws ParserConfigurationException {
        this.actualLevel = getNextLevel();
        this.levelIndex = (this.levelIndex + 1) % this.qtyLevels;
    }

    /**
     * Gets the instance of the next level readed and parsed from the XML files.
     * @return the instance of the next level of type Level.
     * @throws ParserConfigurationException 
     */
    private Level getNextLevel() throws ParserConfigurationException {
        Path mazePath = Paths.get("src", "main", "resources", "Levels", "MazeLevel" + String.valueOf(this.levelIndex) + ".xml");
        Path characterPath = Paths.get("src", "main", "resources", "Levels", "CharactersLevel" + String.valueOf(this.levelIndex) + ".xml");
        return new Level(mazePath, characterPath, controller);
    }

    /**
     * The game is played.
     * @throws InterruptedException 
     */
    public void play() throws InterruptedException {
        boolean keepPlaying = true;
        int totalScore = 0;
        try {
            this.startLevel();
        } catch (ParserConfigurationException ex) {
            keepPlaying = false;
        }
        while (keepPlaying) {
            int score = this.actualLevel.play();
            if (this.actualLevel.gameover()) {
                break;
            }

            //if (!showContinueToNextLevel(score)) break;
            try {
                Thread.sleep(200);
                this.startLevel();
            } catch (Exception ex) {
                keepPlaying = false;
            }
            totalScore += score;
        }
        showEndGame();
    }
    
    /**
     * Shows by a window an image that represents the end of the game.
     * @throws InterruptedException 
     */
    private void showEndGame() throws InterruptedException {
        ViewsFactory.showEndGame();
    }

}
