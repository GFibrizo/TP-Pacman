package com.grupo2.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ivan
 */
public class GraphicNode extends JPanel {

	private Image image;
	private int width;
	private int height;
	private int x;
	private int y;

	public GraphicNode(int width, int height, int x, int y, boolean transitable) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		ImageIcon boardBackground;
		if (transitable) {
			boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "transitableCell.png").toString());
		} else {
			boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "intransitableCell.png").toString());
		}

		this.image = boardBackground.getImage();
		setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
	}
}
