package com.grupo2.graphicView;

import com.grupo2.fruit.Fruit;
import com.grupo2.view.ObjectView;
import java.awt.Dimension;
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
        if (!object.isActive()) {
            this.image = null;
        }
    }

}
