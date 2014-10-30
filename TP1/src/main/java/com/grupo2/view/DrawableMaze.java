package com.grupo2.view;

import com.grupo2.character.Coordinate;
import java.util.ArrayList;

/**
 *
 * @author ivan
 */
public interface DrawableMaze {

    int getWidth();

    int getHeight();

    int getNodeWidth();

    int getNodeHeight();

    Coordinate getPacmanBegining();

    Coordinate getGhostsBegining();

    ArrayList<DrawableNode> getNodes();
}
