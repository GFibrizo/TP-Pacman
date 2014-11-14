package com.grupo2.graphicView;

import com.grupo2.constants.ViewConstants;
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
public class GraphicBigBall extends JLabel {

	private Image image;
	private int width;
	private int height;
	private int x;
	private int y;
        //private Drawable drawableObject;

	/*public GraphicBigBall(int width, int height, int x, int y) {
	 this.width = width;
	 this.height = height;
	 this.x = x;
	 this.y = y;
	 ImageIcon boardBackground = boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "bigball.png").toString());
	 this.image = boardBackground.getImage();
	 setPreferredSize(new Dimension(width, height));
	 }*/
	public GraphicBigBall(int width, int height, int x, int y) {
		this.width = ViewConstants.DRAWABLE_WIDTH;
		this.height = ViewConstants.DRAWABLE_HEIGHT;
		// drawableObject = ball;
		this.x = x;
		this.y = y;
		ImageIcon boardBackground = boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "bigball.png").toString());
		this.image = boardBackground.getImage();
		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, this);
	}
}
