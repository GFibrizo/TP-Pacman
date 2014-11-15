/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.view;
import com.grupo2.constants.ViewConstants;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 *
 * @author fibrizo
 */
public abstract class ObjectView extends JPanel {
    
    protected Image image;
    protected int width  = ViewConstants.DRAWABLE_WIDTH;
    protected int height = ViewConstants.DRAWABLE_HEIGHT;
    protected int x;
    protected int y;
    protected int offset;
    protected JPanel panel;

    public abstract void update();
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, (this.x*this.width)+offset*4, this.y*this.height, this.width, this.height, this);
    }

    void setOffset(int i) {
        this.offset = i;
    }
    
    
}
