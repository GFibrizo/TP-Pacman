package com.grupo2.board;

import com.grupo2.character.Cell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.command.FruitEatenCommand;
import com.grupo2.command.GhostCollidesCommand;
import com.grupo2.command.GhostConvertToPreyCommand;
import com.grupo2.command.GhostIsCloseOrFarFromPacmanCommand;
import com.grupo2.command.MazeBallEaten;
import com.grupo2.command.PacmanDiesCommand;
import com.grupo2.constants.Constants;
import com.grupo2.controller.Controller;
import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import com.grupo2.fruit.Cherry;
import com.grupo2.fruit.Fruit;
import com.grupo2.ghost.Ghost;
import com.grupo2.character.Positionable;
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
    private long fruitTimer;

    /**
     * @return Board an instance of this board.
     */
    public static Board getInstance() {
        return instance;
    }

    /**
     *
     * @param mazeBuilder
     * @param characterBuilder
     */
    private void restart(MazeBuilder mazeBuilder, CharacterBuilder characterBuilder) {
        this.maze = mazeBuilder.buildMaze();
        this.subscribers = new HashMap<>();
        this.ghosts = characterBuilder.getGhosts();
        this.thePacman = characterBuilder.getPacman();
        Cell initialPacmanCell = maze.getCellFromCoordinates(this.maze.getPacmanBegining());
        this.thePacman.setCurrentCell(initialPacmanCell);
        setCellForGhosts();
        this.theFruit = new Cherry(this.maze);
        this.theFruit.die();
        this.fruitTimer = 0;
        PacmanArea.CenterAreaOnPacman(thePacman);
    }

    /**
     * The Events modeled with an enum.
     */
    public static enum GameEvent implements Event {

        PACMANCOLLIDEHUNTER, PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN, PACMANEATSBIGBALL,
        PACMANEATSFRUIT, PACMANEATSLITTLEBALL, PACMANSTARTMOVING, PACMANSTOPMOVING
    }

    /**
     * Class method for creating the Board.
     *
     * @param mazeBuilder that builds the Maze of the Board.
     * @param characterBuilder that builds the characters of the Board.
     * @return Board the board created.
     */
    public static Board createBoard(MazeBuilder mazeBuilder, CharacterBuilder characterBuilder) {
        if (instance == null) {
            instance = new Board(mazeBuilder, characterBuilder);
        } else {
            instance.restart(mazeBuilder, characterBuilder);
        }
        return instance;
    }

    /**
     * Set the current cell of all the ghosts.
     */
    public void setCellForGhosts() {
        this.ghosts.stream().forEach((Ghost ghost) -> {
            ghost.setPosition(this.maze.getGhostsBegining());
            Cell initialGhostCell = maze.getCellFromCoordinates(this.maze.getGhostsBegining());
            ghost.setCurrentCell(initialGhostCell);
        });
    }

    /**
     * Constructor of the class Board
     *
     * @param mazeBuilder that builds the Maze of the Board.
     * @param characterBuilder that builds the characters of the Board.
     */
    public Board(final MazeBuilder mazeBuilder, final CharacterBuilder characterBuilder) {
        this.maze = mazeBuilder.buildMaze();
        this.subscribers = new HashMap<>();
        this.ghosts = characterBuilder.getGhosts();
        this.thePacman = characterBuilder.getPacman();
        Cell initialPacmanCell = maze.getCellFromCoordinates(this.maze.getPacmanBegining());
        this.thePacman.setCurrentCell(initialPacmanCell);
        setCellForGhosts();
        this.theFruit = new Cherry(this.maze);
        this.theFruit.die();
        this.fruitTimer = 0;
        PacmanArea.CenterAreaOnPacman(thePacman);
    }

    /**
     * Subscribe all the subscribers to the corresponding Event with some
     * Publisher.
     */
    public void subscribeSubscribers() {
        this.subscribe(GameEvent.PACMANCOLLIDEHUNTER, new PacmanDiesCommand(this));
        this.subscribe(GameEvent.PACMANEATSFRUIT, new FruitEatenCommand(theFruit));
        for (Ghost ghost : ghosts) {
            this.subscribe(GameEvent.PACMANCOLLIDEGHOST, new GhostCollidesCommand(ghost));
            this.subscribe(GameEvent.PACMANEATSBIGBALL, new GhostConvertToPreyCommand(ghost));
            Subscriber sub = new GhostIsCloseOrFarFromPacmanCommand(ghost);
            PacmanArea.getInstance().subscribe(PacmanArea.VisionEvent.GHOSTCHANGESPOSITION, sub);
        }
        this.subscribe(GameEvent.PACMANEATSLITTLEBALL, new MazeBallEaten(this.maze));
        this.subscribe(GameEvent.PACMANEATSBIGBALL, new MazeBallEaten(this.maze));
    }

    /**
     * @param entity
     * @param otherEntity
     * @return boolean true if there is a collition between the positionables.
     */
    public boolean collisionBetween(Positionable entity, Positionable otherEntity) {
        return maze.areInTheSameCell(entity, otherEntity);
    }

    /**
     * @param entity
     * @return boolean true if there is a collition between the pacman and the
     * positionable.
     */
    public boolean collisionWithPacman(Positionable entity) {
        return maze.areInTheSameCell(thePacman, entity);
    }

    /**
     * Add ghosts to the list of ghosts of the Board.
     *
     * @param aCharacterToAdd
     */
    public void addGhost(Ghost aCharacterToAdd) {
        this.ghosts.add(aCharacterToAdd);
    }

    /**
     * @return the Pacman.
     */
    public Pacman getPacman() {
        return this.thePacman;
    }

    /**
     * This method has the responsability for update the pacman when enters to a
     * cell.
     */
    public void pacmanEntersCell() {
        Cell cell = thePacman.getCurrentCell();
        int points = cell.eatBall();
        thePacman.incrementScore(points);
    }

    /**
     * @return Maze
     */
    public Maze getMaze() {
        return maze;
    }

    /**
     * @return ArrayList<Ghost> the list of ghost in the board.
     */
    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

    /**
     * Resolve all the collitions between the pacman, the ghosts and the fruit
     * updating the states of the subscribers to the collition Events.
     */
    private void resolveCollitions() {
        if ((!theFruit.isDead()) && this.collisionWithPacman(theFruit)) {
            this.update(GameEvent.PACMANEATSFRUIT);
            this.theFruit.die();
        }
        for (Ghost ghost : ghosts) {
            if (this.collisionWithPacman(ghost)) {
                this.update(GameEvent.PACMANCOLLIDEGHOST);
                if (ghost.isHunter()) {
                    this.update(GameEvent.PACMANCOLLIDEHUNTER);
                }
                return;
            }
        }
    }


    /**
     * Update the model. All the characters are moved and updated, the
     * collitions are resolved.
     *
     * @param controller is the one that sends messages with the directions to
     * the pacman.
     */
    public void updateModel(Controller controller) {
        this.thePacman.setDirection(controller.getPacmanNextDirection());
        this.thePacman.move();
        this.createFruit();
        this.pacmanEntersCell();
        PacmanArea.CenterAreaOnPacman(thePacman);
        PacmanArea.getInstance().update(PacmanArea.VisionEvent.GHOSTCHANGESPOSITION);
        resolveCollitions();
        this.theFruit.move();
        for (Ghost ghost : ghosts) {
            ghost.move();
        }
        resolveCollitions();
    }

    /**
     * The view is drawed in the window.
     *
     * @param view is an object composed by the views of all the model
     * components.
     */
    public void updateView(View view) {
        view.update();
        int i = 0;
        view.show(i);
    }

    /**
     * The fruit of the game is created.
     */
    private void createFruit() {
        if (this.theFruit.isDead()) {
            if (this.fruitTimer >= Constants.FRUITSPAWNTICKS) {
                theFruit.revive();
                this.fruitTimer = 0;
            } else {
                this.fruitTimer++;
            }
        }
    }

    /**
     * @return Fruit the fruit of the board
     */
    public Fruit getTheFruit() {
        return this.theFruit;
    }

    /**
     * @return Cell is the cell where the pacman respawns.
     */
    public Cell getPacmanBegin() {
        return this.maze.getCellFromCoordinates(this.maze.getPacmanBegining());
    }

}
