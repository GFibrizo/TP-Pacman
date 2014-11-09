package com.grupo2.board;

import com.grupo2.cell.Cell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.command.*;
import com.grupo2.controller.Controller;
import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.fruit.Cherry;
import com.grupo2.fruit.Fruit;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.pacman.PacmanArea;
import com.grupo2.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mauri
 */
public class Board extends Publisher {

    private Maze maze;
    private ArrayList<Ghost> ghosts = new ArrayList<>();
    private Pacman thePacman;
    private Fruit theFruit;
    private static Board instance;

    public static Board getInstance() {
        return instance;
    }

    public static enum GameEvent implements Event {

        PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN, PACMANEATSBALL, PACMANEATSFRUIT //Etc
    }

    public static Board createBoard(MazeBuilder mazeBuilder, CharacterBuilder characterBuilder) {
        if (instance == null) {
            instance = new Board(mazeBuilder, characterBuilder);
        }
        return instance;
    }

    public static Board createBoard(MazeBuilder mazeBuilder, Pacman thePacman) {
        if (instance == null) {
            instance = new Board(mazeBuilder, thePacman);
        }
        return instance;
    }

    private void setCellForGhosts() {
        for (Ghost ghost : ghosts) {
            Cell initialGhostCell = maze.getCellFromCoordinates(ghost.getInitialPosition());
            ghost.setCurrentCell(initialGhostCell);
        }
    }

    public Board(final MazeBuilder mazeBuilder, final CharacterBuilder characterBuilder) {
        this.maze = mazeBuilder.buildMaze();
        this.subscribers = new HashMap<>();
        this.ghosts = characterBuilder.getGhosts();
        this.thePacman = characterBuilder.getPacman();
        Cell initialPacmanCell = maze.getCellFromCoordinates(this.maze.getPacmanBegining());
        this.thePacman.setCurrentCell(initialPacmanCell);
        setCellForGhosts();
        this.theFruit = new Cherry(this.maze);
        //this.ghosts.forEach((ghost) -> ghost.setPosition(this.maze.getGhostBegining()));
        PacmanArea.CenterAreaOnPacman(thePacman);
    }

    //Este constructor no sirve cuando el Character builder lea las personalidades
    public Board(final MazeBuilder mazeBuilder, Pacman thePacman) {
        this.maze = mazeBuilder.buildMaze();
        this.subscribers = new HashMap<>();
        this.thePacman = thePacman;
        Cell initialPacmanCell = maze.getCellFromCoordinates(this.maze.getPacmanBegining());
        this.thePacman.setCurrentCell(initialPacmanCell);
        setCellForGhosts();
        //this.ghosts.forEach((ghost) -> ghost.setPosition(this.maze.getGhostBegining()));
        PacmanArea.CenterAreaOnPacman(thePacman);
    }

    public void subscribeSubscribers() {
        this.subscribe(GameEvent.PACMANCOLLIDEGHOST, new PacmanDiesCommand(thePacman));
        this.subscribe(GameEvent.PACMANEATSFRUIT, new FruitEatenCommand(theFruit));
        for (Ghost ghost : ghosts) {
            this.subscribe(GameEvent.PACMANCOLLIDEGHOST, new GhostCollidesCommand(ghost));
            this.subscribe(GameEvent.PACMANEATSBALL, new GhostConvertToPreyCommand(ghost));

            Subscriber sub = new GhostIsCloseToPacmanCommand(ghost);
            PacmanArea.getInstance().subscribe(PacmanArea.VisionEvent.GHOST_IS_INSIDE, sub);
        }        
    }

    public boolean collisionBetween(IPositionable entity, IPositionable otherEntity) {
        return maze.areInTheSameCell(entity, otherEntity);
    }

    public boolean collisionWithPacman(IPositionable entity) {
        return maze.areInTheSameCell(thePacman, entity);
    }

    public void addGhost(Ghost aCharacterToAdd) {
        this.ghosts.add(aCharacterToAdd);
    }

    public Pacman getPacman() {
        return this.thePacman;
    }

    public void pacmanEntersCell() {
        //Celda en la que está el pacman
        // MALISIMO
        //TransitableCell cell = (TransitableCell) this.maze.getCellFromCoordinates(this.thePacman.getPosition());
        Cell cell = thePacman.getCurrentCell();
        int points = cell.eatBall();   
    }

    public Maze getMaze() {
        return maze;
    }

    public void isCloseToPacman(IPositionable other) {

    }

    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    private void resolveColitions() {
        if (this.collisionWithPacman(theFruit)) this.update(GameEvent.PACMANEATSFRUIT); 
        for (Ghost ghost : ghosts) {
            if (this.collisionWithPacman(ghost)) {
                this.update(GameEvent.PACMANCOLLIDEGHOST);
                return;
            }
        }
    }
    

    public void updateModel(Controller controller) {
        this.thePacman.setDirection(controller.getPacmanNextDirection());
        this.thePacman.move();
        this.pacmanEntersCell();
        PacmanArea.CenterAreaOnPacman(thePacman);
        PacmanArea.getInstance().update(PacmanArea.VisionEvent.GHOST_IS_INSIDE);
        //update(GameEvent.PACMANCOLLIDEGHOST);
        /*this.ghosts.forEach((Ghost ghost) -> {
         ghost.move();
         });*/

        for (Ghost ghost : ghosts) {
            ghost.move();
        }
        resolveColitions();
    }

    public void updateView(View view) {
        view.show();
    }

}
