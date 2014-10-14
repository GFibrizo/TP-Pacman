package com.grupo2.eventHandling;

/**
 *
 * @author fibrizo
 */
public interface Publisher {

	void subscribe(Event event, Subscriber subscriber);


}
