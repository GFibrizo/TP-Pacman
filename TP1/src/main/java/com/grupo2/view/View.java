package com.grupo2.view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ivan
 */
public abstract class View {

    protected DrawableMaze maze;
    protected List<ObjectView> views;


    public void addObjectViews(List<ObjectView> views) {
        this.views = views;
    }

    public abstract void show(int i);

    public abstract void update();
}
