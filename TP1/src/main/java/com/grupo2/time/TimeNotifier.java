package com.grupo2.time;

import com.grupo2.eventHandling.Event;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import java.util.List;

/**
 *
 * @author ivan
 */
public class TimeNotifier implements Publisher {

    private long ticksSoFar;

    //private observers
    public TimeNotifier() {
        this.ticksSoFar = 0;
    }

    public void requestNotification(TimeoutWaiter waiter) {
        //add to observers list
    }

    public long getTicksSoFar() {
        return ticksSoFar;
    }

    public void addTick() {
        this.ticksSoFar++;
        //For each observer check if tick = tick expected then call timeout
    }

    @Override
    public void subscribe(Event event, Subscriber subscriber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onEvent(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAll(List<Event> events) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
