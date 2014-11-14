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
public abstract class ObjectView extends JLabel {
    
    protected Image image;
    protected int width  = ViewConstants.DRAWABLE_WIDTH;
    protected int height = ViewConstants.DRAWABLE_HEIGHT;
    protected int x;
    protected int y; 

    public abstract void update();
    
    
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
    
    public void setFrame(JFrame frame, JPanel panel) {
        //panel.add(this);
        frame.add(this);
    }
    
}
