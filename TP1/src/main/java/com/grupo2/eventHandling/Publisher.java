package com.grupo2.eventHandling;

import java.util.List;

/**
 *
 * @author fibrizo
 */
public interface Publisher {

    public void subscribe(Event event, Subscriber subscriber);

    public void onEvent(Event event);

    public void updateAll(List<Event> events);

}
