package com.grupo2.interfaces;

import com.grupo2.view.DrawableGhost;

/**
 *
 * @author fibrizo
 */
public interface IGhost extends DrawableGhost {

    public void convertToPrey();

    public void onCollisionWithPacman();

    public int getVision();

}
