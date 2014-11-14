package com.grupo2.graphicView;

import com.grupo2.balls.LittleBall;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ivan
 */
public class GraphicLittleBall extends GraphicBall {
    
    /**
     *
     * @param ball
     * @param x
     * @param y
     */
    public GraphicLittleBall(LittleBall ball, int x, int y) {
        ImageIcon boardBackground = boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "littleball.png").toString());
        this.initialize(ball, x, y, boardBackground);
    }

}
