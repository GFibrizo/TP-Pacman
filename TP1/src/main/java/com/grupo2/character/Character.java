/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.character;

/**
 *
 * @author fibrizo
 */
public abstract class Character {

    Position position;

    protected Character(float x, float y, float radius) {
        this.position = new Position(x, y, radius);
    }

    public abstract void move();

    public abstract boolean isDead();

    public Position getPosition() {
        return position;
    }
}
