/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.ghost.Personality;

/**
 *
 * @author fibrizo
 */
public class HunterStartsChaseOfPacman implements Subscriber {

    Personality ghostPersonality;

    public HunterStartsChaseOfPacman(Personality ghostPersonality) {
        this.ghostPersonality = ghostPersonality;
    }

    @Override
    public void execute() {
        this.ghostPersonality.beginPacmanChase();
    }
}
