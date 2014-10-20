package com.grupo2.interfaces;



/**
 *
 * @author fibrizo
 */
public interface IGhost extends ICharacter {

    public void convertToPrey();
    public void onCollisionWithPacman();
    public int getVision();
        
}
