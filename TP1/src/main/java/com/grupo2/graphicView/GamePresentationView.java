/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Familia
 */
public abstract class GamePresentationView extends JPanel {
    protected Image bImage;
    protected int width;
    protected int height;
    /**
     * Constructor of the Background class.
     * @param width of image
     * @param height of image
     */
    protected GamePresentationView() {
        width = 640;
        height = 480;
        ImageIcon icon = this.initialize();
        this.bImage = icon.getImage();
        this.setPreferredSize(new Dimension(width, height));
    }

    protected abstract ImageIcon initialize();
    
    /**
     * Overrided method for painting the image set in bImage.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(this.bImage, 0, 0, 640, 480, this);
    }
}
