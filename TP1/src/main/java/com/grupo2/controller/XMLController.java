package com.grupo2.controller;

import com.grupo2.character.Direction;
import com.grupo2.directions.RightDirection;
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
        return new RightDirection();
    }

}
