package com.grupo2.view;

import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.Maze;
import com.grupo2.pacman.Pacman;
import java.io.File;

/**
 *
 * @author ivan
 */
public class XMLView implements View {

    private final File xmlFile;

    public XMLView(String path) {
        this.xmlFile = new File(path);
    }

    @Override
    public void persistPacman(Pacman pacman) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persistGhost(IGhost ghost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persistMaze(Maze maze) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}