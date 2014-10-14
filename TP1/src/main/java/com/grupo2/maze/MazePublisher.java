package com.grupo2.maze;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class MazePublisher implements Publisher {

	private Map<MazeEvent, List<Subscriber>> subscribers;

	public enum MazeEvent implements Event {

		PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION //Etc
	}

	private MazePublisher() {
		this.subscribe = new HashMap<>();
	}

	public static MazePublisher getInstance() {
		return MazePublisherHolder.INSTANCE;
	}

	@Override
	public void subscribe(Event event, final Subscriber subscriber) {
		//must check if event is a MazeEvent
		if (!this.subscribers.containsKey(event)) {
			this.subscribers.put(event, new LinkedList<Subscriber>().add(subscriber));
		} else {
			this.subscribers.get(event).add(subscriber);
		}
	}

	private static class MazePublisherHolder {

		private static final MazePublisher INSTANCE = new MazePublisher();
	}
}
