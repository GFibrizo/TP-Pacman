/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;
import com.grupo2.constants.ViewConstants;
import com.grupo2.view.ObjectView;
import javax.swing.JPanel;
import com.grupo2.fruit.Fruit;
import java.awt.Dimension;
import java.awt.Image;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**
 *
 * @author fibrizo
 */
public class FruitView extends ObjectView {
    
    private Fruit object; 
    
    public FruitView(Fruit fruit) {
        this.object = fruit;
       // drawableObject = ball;
        this.x = fruit.getPosition().getX();
        this.y = fruit.getPosition().getY();
        ImageIcon boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "fruit.png").toString());
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
    }


    @Override
    public void update() {
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        if (object.isDead())
            this.image = null;
    }
    
}
