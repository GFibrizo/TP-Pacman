package com.grupo2.character;

import com.grupo2.ghost.Ghost;
import com.grupo2.pacman.Pacman;
import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public interface CharacterBuilder {

    public Pacman getPacman();

    public ArrayList<Ghost> getGhosts();
}
