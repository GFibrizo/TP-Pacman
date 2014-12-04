package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Personality;

/**
 *
 * @author fibrizo
 */
public class HunterStartsChaseOfPacman implements Subscriber {

    /**
     * Personality on which this command has effect.
     */
    private final Personality ghostPersonality;

    /**
     * Constructor.
     *
     * @param ghostPersonality
     */
    public HunterStartsChaseOfPacman(Personality ghostPersonality) {
	this.ghostPersonality = ghostPersonality;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	this.ghostPersonality.beginPacmanChase();
    }
}
