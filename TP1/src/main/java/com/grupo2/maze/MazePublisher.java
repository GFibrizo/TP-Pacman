package com.grupo2.maze;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import java.util.HashMap;

/**
 *
 * @author ivan
 */
public class MazePublisher extends Publisher {


    public static enum MazeEvent implements Event {

        PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN //Etc
    }

    private MazePublisher() {
        this.subscribers = new HashMap<>();
    }

    public static MazePublisher getInstance() {
        return MazePublisherHolder.INSTANCE;
    }

    private static class MazePublisherHolder {

        private static final MazePublisher INSTANCE = new MazePublisher();
    }


}
