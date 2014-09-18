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
public interface IGhost extends ICharacter {
    
    @Override
    public CollidingArea getPosition();
    @Override
    public void move();
    @Override
    public boolean isDead();
    public void die();
    public void convertToPrey();
    public void beEaten(IGhost ghost);
    public boolean isBeingEated(ICharacter someone);
}
