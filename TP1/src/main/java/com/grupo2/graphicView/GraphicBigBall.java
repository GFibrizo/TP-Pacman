package com.grupo2.graphicView;

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
public class GraphicBigBall extends GraphicBall {



	public GraphicBigBall(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		ImageIcon boardBackground = boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "transitableCell.png").toString());
	

		this.image = boardBackground.getImage();
		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
}
