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
 * @author fibrizo
 */
public class GameStartView extends GamePresentationView {

    /**
     * Constructor of the Background class.
     *
     * @param width of image
     * @param height of image
     */
    public GameStartView() {
        super();
    }

    @Override
    protected ImageIcon initialize() {
        return new ImageIcon(Paths.get("src", "main", "graphicResources", "pacman-start.png").toString());
    }
}
