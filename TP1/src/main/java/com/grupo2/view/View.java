package com.grupo2.view;

import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.Maze;
import com.grupo2.pacman.Pacman;

/**
 *
 * @author ivan
 */
public interface View {

    void persistMaze(Maze maze);

    void persistPacman(Pacman pacman);

    void persistGhost(IGhost ghost);
}
