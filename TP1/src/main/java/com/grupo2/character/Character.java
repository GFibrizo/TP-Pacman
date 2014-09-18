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
public abstract class Character implements ICharacter{

    CollidingArea position;

    protected Character(float x, float y, float radius) {
        this.position = new CollidingArea(x, y, radius);
    }

    @Override
    public abstract void move();

    @Override
    public abstract boolean isDead();

    @Override
    public CollidingArea getPosition() {
        return position;
    }
}
