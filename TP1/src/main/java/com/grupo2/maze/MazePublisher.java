package com.grupo2.maze;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ivan
 */
public class MazePublisher implements Publisher {

	private HashMap<Event, List<Subscriber>> subscribers;

	public static enum MazeEvent implements Event {

            PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION, GHOSTISCLOSETOPACMAN //Etc
	}

	private MazePublisher() {
            this.subscribers = new HashMap<>();
	}

	public static MazePublisher getInstance() {
            return MazePublisherHolder.INSTANCE;
	}

	@Override
	public void subscribe(Event event, final Subscriber subscriber) {
            //must check if event is a MazeEvent
            if (!this.subscribers.containsKey(event)) {
                this.subscribers.put(event, new LinkedList<Subscriber>());
            }
            this.subscribers.get(event).add(subscriber);
	}

	private static class MazePublisherHolder {

            private static final MazePublisher INSTANCE = new MazePublisher();
	}

        @Override
        public void onEvent(Event event) {

            List<Subscriber> subs = subscribers.get(event);
            for (Subscriber sub : subs) {
		sub.execute();
            }
        }

        @Override
        public void updateAll(List<Event> events) {
            for (Event event : events) {
                onEvent(event);
            }
        }


}
