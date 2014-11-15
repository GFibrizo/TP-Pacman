/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.graphicView;
import com.grupo2.ghost.*;
import com.grupo2.view.ObjectView;
import java.awt.Dimension;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import com.grupo2.ghostState.*;

/**
 *
 * @author fibrizo
 */
public class GhostView extends ObjectView {
    
    private Ghost object; 
    
    public GhostView(Ghost ghost) {
        this.object = ghost;
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = chooseImage();
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));
    }
    
    private ImageIcon chooseImage() {
        // THIS METHOD HAS TO BE CHANGED TO SUPPORT DIRECTIONS OF GHOSTS
        String stringState;
        if (HunterState.class.isInstance(object.getState()))
            stringState = "hunter.png";
        else if (PreyState.class.isInstance(object.getState()))
            stringState = "prey.png";
        else 
            stringState = "dead.png";
        return new ImageIcon(Paths.get("src", "main", "graphicResources", stringState).toString());
    }
    

    @Override
    public void update() {
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        if (object.isDead()) {
            this.image = null;
            return;
        }
        ImageIcon boardBackground = chooseImage();
        this.image = boardBackground.getImage();
    }


    
}
