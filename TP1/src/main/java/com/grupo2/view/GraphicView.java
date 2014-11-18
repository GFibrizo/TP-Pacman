package com.grupo2.view;

import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import com.grupo2.constants.ViewConstants;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.maze.Maze;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class GraphicView extends View {

    private JFrame frame;
    private JPanel p;
    private JLayeredPane lPane;

    private GraphicView(Maze maze) {
        this.maze = maze;
        this.frame = new JFrame("Pacman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ViewConstants.DRAWABLE_WIDTH * maze.getWidth(), ViewConstants.DRAWABLE_HEIGHT * maze.getHeight());
        frame.setLocationRelativeTo(null);
        this.p = null;
    }

    public static GraphicView createGraphicView(Maze maze) {
        return new GraphicView(maze);
    }

    @Override
    public void show(int i) {
        if (p != null) {
            frame.remove(p);
        }
        ArrayList<DrawableNode> cells = this.maze.getNodes();
        int width = this.maze.getWidth();
        int height = this.maze.getHeight();
        int dimensionW = width * ViewConstants.DRAWABLE_WIDTH;
        int dimensionH = height * ViewConstants.DRAWABLE_HEIGHT;
        Background bgPanel = new Background(dimensionW, dimensionH);
        bgPanel.setLayout(new GridLayout(width, height));
        JPanel ballsPanel = new JPanel();
        ballsPanel.setPreferredSize(new Dimension(dimensionW, dimensionH));
        ballsPanel.setLayout(new GridLayout(width, height));
        bgPanel.setOpaque(false);
        p = new JPanel();
        p.setLayout(new OverlayLayout(p));

        cells.forEach((cell) -> {

            boolean transitable = cell.isTransitable();
            GraphicNode node = new GraphicNode(ViewConstants.DRAWABLE_WIDTH, ViewConstants.DRAWABLE_HEIGHT, 0, 0, transitable);
            node.setOpaque(false);

            if (transitable) {
                if (cell.hasBigBall()) {
                    node.add(new GraphicBigBall((BigBall) cell.getBall(), 0, 0));
                }
                if (cell.hasLittleBall()) {
                    node.add(new GraphicLittleBall((LittleBall) cell.getBall(), 0, 0));
                }
            }
            bgPanel.add(node);
        });


        for (ObjectView view : views) {
            view.setOpaque(false);
            //view.setOffset(i);
            p.add(view);
        }

        p.add(bgPanel);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);

    }

    public void setKeyListener(KeyListener kl) {
        this.frame.addKeyListener(kl);
    }

    @Override
    public void update() {
        for (ObjectView view : views) {
            view.update();
        }
    }

}
