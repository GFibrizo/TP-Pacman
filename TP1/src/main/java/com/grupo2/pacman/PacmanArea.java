/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.pacman;
import com.grupo2.eventHandling.Event;
import com.grupo2.interfaces.IGhost;
import com.grupo2.eventHandling.Publisher;
import com.grupo2.eventHandling.Subscriber;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


/**
 *
 * @author fibrizo
 */
public class PacmanArea implements Publisher {
    
    private static int xCenter;
    private static int yCenter;
    private static PacmanArea instance;
    private Map<Event, List<Subscriber>> subscribers;

    public static enum VisionEvent implements Event {

        GHOST_IS_INSIDE, GHOST_IS_OUTSIDE
    }
    
    
    private PacmanArea() {
        subscribers = new HashMap<>();
    }
    
    public static void CenterAreaOnPacman(Pacman pacman) {
        if (instance == null) instance = new PacmanArea();
        xCenter = pacman.getPosition().getX();
        yCenter = pacman.getPosition().getY();
    }
    
    public static PacmanArea getInstance() {
        return instance;
    }
    
    private boolean isInRange(int x, int center, int offset) {
        return ((x > center - offset) && (x < center + offset));
    }
    
    
    public static boolean isInside(IGhost ghost) {
        if(instance == null) 
            throw new UnsupportedOperationException("The Area is not centered");
        int x = ghost.getPosition().getX();
        int y = ghost.getPosition().getY();
        int vision = ghost.getVision();
        if ((instance.isInRange(x, xCenter, vision)) && 
            (instance.isInRange(y, yCenter, vision))) {
            return true;
        } 
        return false;
    }

    @Override
    public void subscribe(Event event, Subscriber subscriber) {
        if (!subscribers.containsKey(event))
            subscribers.put(event, new ArrayList<>());
        subscribers.get(event).add(subscriber);
    }

    @Override
    public void onEvent(Event event) {
        List<Subscriber> subs = subscribers.get(event);
        for (Subscriber sub : subs) {
            if (sub.execute()) subs.remove(sub); 
        }
    }

    @Override
    public void updateAll(List<Event> events) {
        for (Event event : events) {
            onEvent(event);
        }
    }
    
}
