package com.grupo2.character;

import com.grupo2.interfaces.IGhost;
import com.grupo2.pacman.Pacman;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public interface CharacterBuilder {
    Pacman getPacman();
    ArrayList<IGhost> getGhosts();
}
