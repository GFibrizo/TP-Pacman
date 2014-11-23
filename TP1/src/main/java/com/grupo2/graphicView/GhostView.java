package com.grupo2.graphicView;

import com.grupo2.ghost.Ghost;
import com.grupo2.view.ObjectView;
import java.awt.Dimension;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import com.grupo2.directions.*;

/**
 *
 * @author fibrizo
 */
public class GhostView extends ObjectView {

    private Ghost object;
    private int count;

    public GhostView(Ghost ghost) {
        this.object = ghost;
        this.x = object.getPosition().getX();
        this.y = object.getPosition().getY();
        ImageIcon boardBackground = chooseImage();
        this.image = boardBackground.getImage();
        setPreferredSize(new Dimension(width, height));

    }

    private ImageIcon chooseImage() {
        String spriteName;
        if (object.isHunter()) {
            spriteName = "Hunter";
            count = 0;
            spriteName += this.returnStringOfPersonality();
            spriteName += this.returnStringOfDirection();
        } else if (object.isPrey()) {
            spriteName = "Blue";
            spriteName += this.returnNumberOfSprite();
        } else {
            spriteName = null;
        }
        return new ImageIcon(Paths.get("src", "main", "graphicResources", spriteName + ".png").toString());
    }

    private String returnNumberOfSprite() {
        if (count == 0) {
            count++;
            return "First";
        } else {
            count = 0;
            return "Second";
        }
    }

    private String returnStringOfDirection() {
        if (object.getDirection().EqualTo(new UpDirection())) {
            return "Up";
        }
        if (object.getDirection().EqualTo(new DownDirection())) {
            return "Down";
        }
        if (object.getDirection().EqualTo(new RightDirection())) {
            return "Right";
        }
        if (object.getDirection().EqualTo(new LeftDirection())) {
            return "Left";
        }
        return "Left";
    }

    private String returnStringOfPersonality() {
        if (object.isDumb()) {
            return "Pink";
        }
        if (object.isLazy()) {
            return "SkyBlue";
        }
        if (object.isSeeker()) {
            return "Orange";
        }
        if (object.isTemperamentalSeeker()) {
            return "Red";
        }
        return "Red";
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
