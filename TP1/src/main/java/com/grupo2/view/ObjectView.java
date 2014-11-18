package com.grupo2.view;

import com.grupo2.constants.ViewConstants;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author fibrizo
 */
public abstract class ObjectView extends JPanel {

    protected Image image;
    protected int width = ViewConstants.DRAWABLE_WIDTH;
    protected int height = ViewConstants.DRAWABLE_HEIGHT;
    protected int x;
    protected int y;
    protected int offset;
    protected JPanel panel;

    public abstract void update();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, (this.x * this.width), (this.y * this.height), this.width, this.height, this);
    }

    void setOffset(int i) {
        this.offset = i;
    }

}
