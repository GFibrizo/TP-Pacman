/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.game;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.InputReader;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.GraphicView;
import javax.xml.parsers.ParserConfigurationException;
import java.nio.file.Path;
import com.grupo2.view.View;

/**
 *
 * @author Familia
 */
public class Level {
    
    private Pacman thePacman;
    private Ghost theGhost;
    private Maze maze;
    private Board map;
    private InputReader reader;
    private Controller controller;
    private boolean ended;
    private View view;
    
    public Level(Path mazeFilePath, Path charactersFilePath, Controller controller) throws ParserConfigurationException {
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(mazeFilePath);
        CharacterBuilder charBuilder = new CharacterXMLBuilder(charactersFilePath);
        map = Board.createBoard(mazeBuilder, charBuilder);
        map.subscribeSubscribers();
	this.controller = controller;
        thePacman = map.getPacman();
        
        
        
        this.view = new View();     ///////// NO SE COMO SE TIENE QUE HACER
        this.view.setMaze(map.getMaze());
        this.view.setPacman(map.getPacman());
        
        
        map.getGhosts().forEach((Ghost ghost) -> {
            this.view.addGhost(ghost);
        });
        ended = false;
    }
    
    
    private initializeViews() {
        GraphicView view = new GraphicView(maze);
            view.drawMaze();
            view.show();
    }
    
    /** 
     * @return int score obtained in the level.
    **/
    public int play() {
        while (!ended) {
            map.updateModel(controller);
            map.updateView(this.view);
            if ((!thePacman.hasLives()) && (thePacman.isDead())) 
                ended = true;
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
