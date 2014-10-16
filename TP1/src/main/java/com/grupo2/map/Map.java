package com.grupo2.map;

import com.grupo2.balls.NullBall;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.interfaces.IGhost;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.pacman.Pacman;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Map {

    private Maze maze;
    private ArrayList<IGhost> ghosts = new ArrayList<>();
    private Pacman thePacman;
    //private static Map mapSingleton = null;

    public Map(final MazeBuilder mazeBuilder, final CharacterBuilder characterBuilder) {
        this.maze = mazeBuilder.buildMaze();
        this.ghosts = characterBuilder.getGhosts();
        this.thePacman = characterBuilder.getPacman();
        this.thePacman.setPosition(this.maze.getPacmanBegining());
        this.ghosts.forEach((ghost) -> ghost.setPosition(this.maze.getGhostBegining()));
    }

    public boolean collisionBetween(IPositionable entity, IPositionable otherEntity) {
        return maze.areInTheSameCell(entity, otherEntity);
    }

    public boolean collisionWithPacman(IPositionable entity) {
        return maze.areInTheSameCell(thePacman, entity);
    }

    public void addGhost(IGhost aCharacterToAdd) {
        this.ghosts.add(aCharacterToAdd);
    }

    public void pacmanEntersCell() {

        //Celda en la que está el pacman
        TransitableCell cell = (TransitableCell) this.maze.getCellFromCoordinates(this.thePacman.getPosition());

        cell.eatBall();
        cell.getBall().isEaten();
        cell.setBall(new NullBall());
    }

    public Maze getMaze() {
        return maze;
    }

    public Pacman getPacman() {
        return this.thePacman;
    }

    public ArrayList<IGhost> getGhosts() {
        return this.ghosts;
    }

    /*	public static Map getInstance() {
     if (mapSingleton == null) {
     mapSingleton = new Map();
     }
     return mapSingleton;
     }*/
}
