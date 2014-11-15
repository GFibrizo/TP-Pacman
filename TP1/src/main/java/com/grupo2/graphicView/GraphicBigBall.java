package com.grupo2.graphicView;

import com.grupo2.constants.ViewConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.grupo2.constants.ViewConstants;
import com.grupo2.balls.Ball;
import com.grupo2.balls.BigBall;

/**
 *
 * @author ivan
 */
public class GraphicBigBall extends GraphicBall {
	
     public GraphicBigBall(BigBall ball, int x, int y) {
        ImageIcon boardBackground = boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "bigball.png").toString());
        this.initialize(ball, x, y, boardBackground);
    }
}
