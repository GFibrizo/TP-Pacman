package com.grupo2.view;

/**
 *
 * @author ivan
 */
public interface View {

    void setMaze(DrawableMaze maze);

    void setPacman(DrawablePacman pacman);

    void addGhost(DrawableGhost ghost);

    void show();
}
