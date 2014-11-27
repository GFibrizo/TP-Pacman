package com.grupo2.graphicView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.grupo2.constants.ViewConstants;

/**
 *
 * @author ivan
 */
public class Background extends JPanel {

    private final Image bImage;

    /**
     * Constructor of the Background class.
     *
     * @param width of image
     * @param height of image
     */
    public Background(int width, int height) {
        ImageIcon boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "background.jpg").toString());
        this.bImage = boardBackground.getImage();
        this.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Overrided method for painting the image set in bImage.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(this.bImage, 0, 0, null);
    }
}
