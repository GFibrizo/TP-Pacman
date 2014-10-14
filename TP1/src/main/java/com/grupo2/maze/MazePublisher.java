package com.grupo2.maze;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author ivan
 */
public class MazePublisher implements Publisher {

	public enum MazeEvent implements Event {

		PACMANCOLLIDEGHOST, GHOSTREACHEDINTERJECTION //Etc
	}

	private MazePublisher() {
	}

	public static MazePublisher getInstance() {
		return MazePublisherHolder.INSTANCE;
	}

	@Override
	public void subscribe(Event event, Subscriber subscriber) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void publish() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private static class MazePublisherHolder {

		private static final MazePublisher INSTANCE = new MazePublisher();
	}
}
