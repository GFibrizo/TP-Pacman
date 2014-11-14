/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;
import com.grupo2.view.ObjectView;
import com.grupo2.pacman.Pacman;
import java.awt.Dimension;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.constants.ViewConstants;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import java.awt.LayoutManager;

/**
 *
 * @author fibrizo
 */
public class PacmanView extends ObjectView {

    Pacman object;
    JPanel panel;
    
    public PacmanView(Pacman pacman) {
        this.object = pacman;
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground  = new ImageIcon(ViewConstants.PACMAN_LEFT);
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
        panel = new JPanel();
        LayoutManager overlay = new OverlayLayout(panel);
        panel.setLayout(overlay);
        panel.add(this);
    }
    
    
    
    private ImageIcon chooseImage() {
        if (object.getDirection().EqualTo(new LeftDirection()))
            return new ImageIcon(ViewConstants.PACMAN_LEFT);
        else if (object.getDirection().EqualTo(new RightDirection()))
            return new ImageIcon(ViewConstants.PACMAN_RIGHT);
        else
            return null;
            
    }

    @Override
    public void update() {
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = chooseImage();
        if (boardBackground != null)
            this.image = boardBackground.getImage();
    }
    
}
