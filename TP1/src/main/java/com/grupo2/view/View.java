package com.grupo2.view;

import java.util.ArrayList;
import java.util.List;
import com.grupo2.graphicView.GraphicBall;

/**
 *
 * @author ivan
 */
public abstract class View {

    protected DrawableMaze maze;
    protected List<ObjectView> views;
    protected List<GraphicBall> ballsViews;

    public void addObjectViews(List<ObjectView> views) {
        this.views = views;
    }

    public abstract void show(int i);

    public abstract void update();
    
    public abstract void initialize();
}
