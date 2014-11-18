/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;

import com.grupo2.constants.ViewConstants;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.pacman.Pacman;
import com.grupo2.view.ObjectView;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author fibrizo
 */
public class PacmanView extends ObjectView {

    private Pacman object;

    public PacmanView(Pacman pacman) {
        this.object = pacman;
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = new ImageIcon(ViewConstants.PACMAN_RIGHT);
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
    }

    private ImageIcon chooseImage() {
        if (object.getDirection().EqualTo(new LeftDirection())) {
            return new ImageIcon(ViewConstants.PACMAN_LEFT);
        } else if (object.getDirection().EqualTo(new RightDirection())) {
            return new ImageIcon(ViewConstants.PACMAN_RIGHT);
        } else if (object.getDirection().EqualTo(new UpDirection())) {
            return new ImageIcon(ViewConstants.PACMAN_UP);
        } else if (object.getDirection().EqualTo(new DownDirection())) {
            return new ImageIcon(ViewConstants.PACMAN_DOWN);
        } else {
            return null;
        }

    }

    @Override
    public void update() {
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = chooseImage();
        if (boardBackground != null) {
            this.image = boardBackground.getImage();
        }
    }

}
