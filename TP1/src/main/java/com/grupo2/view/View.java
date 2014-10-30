package com.grupo2.view;

/**
 *
 * @author ivan
 */
public interface View {

    void reloadMaze(DrawableMaze maze);

    void reloadPacman(DrawablePacman pacman);

    void reloadGhost(DrawableGhost ghost);
}
