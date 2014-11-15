package com.grupo2.game;


import com.grupo2.character.CharacterBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.InputReader;
import com.grupo2.maze.MazeBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import com.grupo2.controller.KeyBoardReader;

/**
 *
 * @author mauri
 */
public class Game {

    private MazeBuilder mazeBuilder;
    private InputReader reader;
    private CharacterBuilder charactBuilder;
    private Controller controller;
    private Level actualLevel;
    private Integer levelIndex;

    public Game() {
        this.reader = new KeyBoardReader();
        this.mazeBuilder = mazeBuilder;
        this.reader = reader;
        this.charactBuilder = charactBuilder;
        controller = new Controller(this.reader);
        levelIndex = 0;
    }

    //TODO: Builders should depend on pgm arguments or something like that
    public void startGame() throws ParserConfigurationException {
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
        do {
            int score = actualLevel.play();
            //if (!showContinueToNextLevel(score)) break;
            levelIndex++;
            try {
                actualLevel = getNextLevel(levelIndex.toString());
            } catch (ParserConfigurationException ex) {
                keepPlaying = false;
            }
            totalScore += score;
        } while (keepPlaying);   
        //showEndGame(totalScore);
    }

}
