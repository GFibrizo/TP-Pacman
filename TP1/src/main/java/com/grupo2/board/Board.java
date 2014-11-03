package com.grupo2.board;

import com.grupo2.cell.Cell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.command.GhostCollidesCommand;
import com.grupo2.command.GhostIsCloseToPacmanCommand;
import com.grupo2.command.PacmanDiesCommand;
import com.grupo2.controller.Controller;
import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.pacman.PacmanArea;
import com.grupo2.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mauri
 */
public class Board implements Publisher {

    private Maze maze;
    private ArrayList<Ghost> ghosts = new ArrayList<>();
    private Pacman thePacman;
    private HashMap<Event, List<Subscriber>> subscribers;
    private static Board instance;

    public static Board getInstance() {
        return instance;
    }

    public static enum GameEvent implements Event {

        PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN //Etc
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
        for (Ghost ghost : ghosts) {
            this.subscribe(GameEvent.PACMANCOLLIDEGHOST, new GhostCollidesCommand(ghost));
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
        TransitableCell cell = (TransitableCell) this.maze.getCellFromCoordinates(this.thePacman.getPosition());
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

    @Override
    public void subscribe(Event event, final Subscriber subscriber) {
        //must check if event is a MazeEvent
        if (!this.subscribers.containsKey(event)) {
            this.subscribers.put(event, new LinkedList<>());
        }
        this.subscribers.get(event).add(subscriber);
    }

    @Override
    public void update(Event event) {
        List<Subscriber> subs = subscribers.get(event);
        subs.forEach(Subscriber::execute);
    }

    @Override
    public void updateAll(List<Event> events) {
        events.forEach((Event event) -> {
            this.update(event);
        });
    }

}
