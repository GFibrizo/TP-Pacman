package com.grupo2.character;

import com.grupo2.interfaces.IGhost;
import com.grupo2.pacman.Pacman;
import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public interface CharacterBuilder {

    public void obtainCharactersFromXML();

    public Pacman getPacman();

    public ArrayList<IGhost> getGhosts();
}
