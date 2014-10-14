package com.grupo2.map;

import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.interfaces.IPositionable;
import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeXMLBuilder;
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
	private static Map mapSingleton;

	private Map() {
		MazeXMLBuilder mazeBuilder = new MazeXMLBuilder("path");
		CharacterXMLBuilder characterBuilder = new CharacterXMLBuilder("path");
		this.maze = mazeBuilder.buildMaze();
		this.ghosts = characterBuilder.getGhosts();
		this.thePacman = characterBuilder.getPacman();
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

	public Pacman getPacman() {
		return this.thePacman;
	}

	public static Map getInstance() {
		if (mapSingleton == null) {
			mapSingleton = new Map();
		}
		return mapSingleton;
	}
}
