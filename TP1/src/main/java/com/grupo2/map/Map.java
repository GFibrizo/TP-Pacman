package com.grupo2.map;

import com.grupo2.cell.TransitableCell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.IGhost;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.View;
import java.util.ArrayList;

/**
 *
 * @author mauri
 */
public class Map {

    private Maze maze;
    private ArrayList<IGhost> ghosts = new ArrayList<>();
    private Pacman thePacman;

    public Map(final MazeBuilder mazeBuilder, final CharacterBuilder characterBuilder) {
        this.maze = mazeBuilder.buildMaze();
        this.ghosts = characterBuilder.getGhosts();
        characterBuilder.obtainCharactersFromXML();
        this.thePacman = characterBuilder.getPacman();
        this.thePacman.setPosition(this.maze.getPacmanBegining());
        this.thePacman.setCurrentCell(this.maze.getCellFromCoordinates(this.thePacman.getPosition()));
        this.ghosts.forEach((ghost) -> ghost.setPosition(this.maze.getGhostBegining()));
    }

    //Este constructor no sirve cuando el Character builder lea las personalidades
    public Map(final MazeBuilder mazeBuilder, Pacman thePacman) {
        this.maze = mazeBuilder.buildMaze();
        this.thePacman = thePacman;
        this.thePacman.setPosition(this.maze.getPacmanBegining());
        this.ghosts.forEach((ghost) -> ghost.setPosition(this.maze.getGhostBegining()));
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

    public ArrayList<IGhost> getGhosts() {
        return this.ghosts;
    }

    public void updateModel(Controller controller) {
        this.thePacman.setDirection(controller.getPacmanNextDirection());
        this.thePacman.move();
        this.ghosts.forEach((IGhost ghost) -> {
            ghost.move();
        });
        this.pacmanEntersCell();
    }

	public void updateView(View view) {
		view.show();
	}

}
