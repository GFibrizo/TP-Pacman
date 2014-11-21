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
import javax.swing.JPopupMenu;
import java.awt.PopupMenu;

/**
 *
 * @author fibrizo
 */
public class GameStartView extends JPanel {
       private final Image bImage;

    /**
     * Constructor of the Background class.
     * @param width of image
     * @param height of image
     */
    public GameStartView() {
        int width = 640;
        int height = 480;
        ImageIcon start = new ImageIcon(Paths.get("src", "main", "graphicResources", "pacman-start.png").toString());
        this.bImage = start.getImage();
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Overrided method for painting the image set in bImage.
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(this.bImage, 0, 0, this);
    }
}
