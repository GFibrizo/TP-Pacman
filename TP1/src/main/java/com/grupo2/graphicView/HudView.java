/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;

import com.grupo2.constants.ViewConstants;
import com.grupo2.view.ObjectView;
import com.grupo2.pacman.Pacman;
import java.awt.Dimension;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author fibrizo
 */
public class HudView extends ObjectView {

    private Pacman object;
    private JPanel lifes;
    private JPanel score;
    private JLabel scoreText;
    private JLabel lifesText;

    public HudView(int w, int h) {
        object = Pacman.getPacman();
        this.x = 1;
        this.y = 0; //h - 1;
        width = (w * ViewConstants.DRAWABLE_WIDTH) / 3;
        height = height;
        ImageIcon hudBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "white.png").toString());
        this.image = hudBackground.getImage();
        setPreferredSize(new Dimension(width, height));

        lifesText = new JLabel();
        lifesText.setText("Lifes: " + String.valueOf(object.remainingLifes()));
        this.add(lifesText);

        scoreText = new JLabel();
        scoreText.setText("Score: " + (String.valueOf(object.getScore())));
        this.add(scoreText);

    }

    @Override
    public void update() {
        lifesText.setText("Lifes: " + String.valueOf(object.remainingLifes()));
        scoreText.setText("Score: " + (String.valueOf(object.getScore())));
    }

}
