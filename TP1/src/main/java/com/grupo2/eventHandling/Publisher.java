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
    
    
    public void subscribe(Event event, final Subscriber subscriber) {
        //must check if event is a MazeEvent
        if (!this.subscribers.containsKey(event)) {
            this.subscribers.put(event, new LinkedList<>());
        }
        this.subscribers.get(event).add(subscriber);
    }

    public void update(Event event) {
        List<Subscriber> subs = subscribers.get(event);
        if ((subs == null) || (subs.isEmpty())) return;
        subs.forEach(Subscriber::execute);
    }

    
    public void updateAll(List<Event> events) {
        events.forEach((Event event) -> {
            this.update(event);
        });
    }

}
