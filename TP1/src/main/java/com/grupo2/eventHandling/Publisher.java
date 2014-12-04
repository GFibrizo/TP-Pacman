package com.grupo2.eventHandling;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fibrizo
 */
public abstract class Publisher {

    protected HashMap<Event, List<Subscriber>> subscribers;

    /**
     * Subscribes an object to an event.
     * @param event the event the object wants to subscribe to.
     * @param subscriber the object who wants to be subscribed.
     */
    public void subscribe(Event event, final Subscriber subscriber) {
        if (!this.subscribers.containsKey(event)) {
            this.subscribers.put(event, new LinkedList<>());
        }
        this.subscribers.get(event).add(subscriber);
    }

    /**
     * Triggers an event.
     * @param event the event that happened.
     */
    public void update(Event event) {
        List<Subscriber> subs = subscribers.get(event);
        if ((subs == null) || (subs.isEmpty())) {
            return;
        }
        subs.forEach(Subscriber::execute);
    }

    /**
     * Updates all events.
     * @param events a list of events to trigger.
     */
    public void updateAll(List<Event> events) {
        events.forEach((Event event) -> {
            this.update(event);
        });
    }

}
