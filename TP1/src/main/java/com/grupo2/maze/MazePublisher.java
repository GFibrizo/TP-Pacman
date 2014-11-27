package com.grupo2.maze;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import java.util.HashMap;

/**
 *
 * @author ivan
 */
public class MazePublisher extends Publisher {

    /**
     * The events of the game that belongs to this particular Publisher.
     */
    public static enum MazeEvent implements Event {

        PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN //Etc
    }

    /**
     * Private constructor of the MazePublisher class.
     * This is a singleton.
     */
    private MazePublisher() {
        this.subscribers = new HashMap<>();
    }

    /**
     * @return the instance of the MazePublisher.
     */
    public static MazePublisher getInstance() {
        return MazePublisherHolder.INSTANCE;
    }

    /**
     * Creator of the instance of MazePublisher.
     */
    private static class MazePublisherHolder {

        private static final MazePublisher INSTANCE = new MazePublisher();
    }

}
