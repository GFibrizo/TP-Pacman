package com.grupo2.controller;

import com.grupo2.character.Direction;
import java.io.File;

/**
 *
 * @author ivan
 */
public class XMLController implements Controller {

    private final File xmlFile;

    public XMLController(String path) {
        this.xmlFile = new File(path);
    }

    @Override
    public Direction getPacmanNextDirection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
