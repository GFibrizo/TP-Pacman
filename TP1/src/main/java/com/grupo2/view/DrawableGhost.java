package com.grupo2.view;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghostState.Personality;

/**
 *
 * @author ivan
 */
public interface DrawableGhost {

    int getNumber();

    Coordinate getPosition();

    Direction getDirection();

    GhostState getState();

    Personality getPersonality();
}
