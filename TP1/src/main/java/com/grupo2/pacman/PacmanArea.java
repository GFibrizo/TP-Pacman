package com.grupo2.pacman;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.ghost.Ghost;
import java.util.HashMap;

/**
 *
 * @author fibrizo
 */
public class PacmanArea extends Publisher {

    private static int xCenter;
    private static int yCenter;
    private static PacmanArea instance;

    public static enum VisionEvent implements Event {

        GHOST_IS_INSIDE, GHOST_IS_OUTSIDE
    }

    private PacmanArea() {
        subscribers = new HashMap<>();
    }

    public static void CenterAreaOnPacman(Pacman pacman) {
        if (instance == null) {
            instance = new PacmanArea();
        }
        xCenter = pacman.getPosition().getX();
        yCenter = pacman.getPosition().getY();
    }

    public static PacmanArea getInstance() {
        return instance;
    }

    private boolean isInRange(int x, int center, int offset) {
        return ((x > center - offset) && (x < center + offset));
    }

    public static boolean isInside(Ghost ghost) {
        if (instance == null) {
            throw new UnsupportedOperationException("The Area is not centered");
        }
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        int vision = ghost.getVision();
        if ((instance.isInRange(x, xCenter, vision))
                && (instance.isInRange(y, yCenter, vision))) {
            return true;
        }
        return false;
    }

}
