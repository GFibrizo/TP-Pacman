package com.grupo2.game;


import com.grupo2.character.CharacterBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.InputReader;
import com.grupo2.maze.MazeBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;

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

    public Game(MazeBuilder mazeBuilder, CharacterBuilder charactBuilder, InputReader reader) {
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
        Path mazePath = Paths.get("src", "main", "resources", "Levels", "Level"+ index, "Maze.xml");
        Path characterPath = Paths.get("src", "main", "resources", "Levels", "Level"+ index, "Characters.xml");
        return new Level(mazePath, characterPath, controller);
    }


    public void play() {
        boolean keepPlaying = true;

        do {
            actualLevel.play();
            //if (!showContinueToNextLevel()) break;
            levelIndex++;
            try {
                actualLevel = getNextLevel(levelIndex.toString());
            } catch (ParserConfigurationException ex) {
                keepPlaying = false;
            }
        } while (keepPlaying);   
        //showEndGame();
    }

}
