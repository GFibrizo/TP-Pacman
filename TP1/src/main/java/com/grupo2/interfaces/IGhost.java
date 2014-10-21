package com.grupo2.interfaces;

import com.grupo2.character.Direction;
import java.util.ArrayList;



/**
 *
 * @author fibrizo
 */
public interface IGhost extends ICharacter {

    public void convertToPrey();
    public void onCollisionWithPacman();
    public int getVision();
    public ArrayList<Direction> allowedDirections();
        
}
