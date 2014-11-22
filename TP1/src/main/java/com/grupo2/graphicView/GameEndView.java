/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;

import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**
 *
 * @author Familia
 */
public class GameEndView extends GamePresentationView {
        /**
     * Constructor of the Background class.
     * @param width of image
     * @param height of image
     */
    public GameEndView() {
        super();
    }

    @Override
    protected ImageIcon initialize() {
        return new ImageIcon(Paths.get("src", "main", "graphicResources", "pacman-game-over.png").toString());
    }
}
