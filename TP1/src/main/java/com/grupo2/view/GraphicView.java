package com.grupo2.view;

import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import com.grupo2.constants.ViewConstants;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicBall;
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
import com.grupo2.graphicView.HudView;

public class GraphicView extends View {

    private JFrame frame;
    private JPanel p;
    private JLayeredPane lPane;
    private Background bgPanel;
    private HudView hud;

    private GraphicView(Maze maze, JFrame frame) {
        this.maze = maze;
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ViewConstants.DRAWABLE_WIDTH * maze.getWidth(), ViewConstants.DRAWABLE_HEIGHT * maze.getHeight());
        frame.setLocationRelativeTo(null);
        int width = this.maze.getWidth();
        int height = this.maze.getHeight();
        int dimensionW = width * ViewConstants.DRAWABLE_WIDTH;
        int dimensionH = height * ViewConstants.DRAWABLE_HEIGHT;
        bgPanel = new Background(dimensionW, dimensionH);
        bgPanel.setLayout(new GridLayout(width, height));
        JPanel ballsPanel = new JPanel();
        ballsPanel.setPreferredSize(new Dimension(dimensionW, dimensionH));
        ballsPanel.setLayout(new GridLayout(width, height));
        this.p = new JPanel();
        p.setLayout(new OverlayLayout(p));
        hud = new HudView(width, height);

        ballsViews = new ArrayList<>();
        ArrayList<DrawableNode> cells = this.maze.getNodes();
        cells.forEach((cell) -> {
            boolean transitable = cell.isTransitable();
            GraphicNode node = new GraphicNode(ViewConstants.DRAWABLE_WIDTH, ViewConstants.DRAWABLE_HEIGHT, 0, 0, transitable);
            node.setOpaque(false);
            GraphicBall ballView = null;
            int x = cell.getCoords().getX();
            int y = cell.getCoords().getY();

            if (transitable) {
                if (cell.hasBigBall()) {
                    ballView = new GraphicBigBall((BigBall) cell.getBall(), x, y);
                } else if (cell.hasLittleBall()) {
                    ballView = new GraphicLittleBall((LittleBall) cell.getBall(), x, y);
                }
            }
            if (ballView != null) {
                ballsViews.add(ballView);
            }
            bgPanel.add(node);
        });

    }

    public static GraphicView createGraphicView(Maze maze, JFrame frame) {
        return new GraphicView(maze, frame);
    }

    @Override
    public void initialize() {
        for (ObjectView view : views) {
            view.setOpaque(false);
            p.add(view);
        }

        hud.setOpaque(false);
        p.add(hud);

        for (GraphicBall view : ballsViews) {
            view.setOpaque(false);
            p.add(view);
        }

        p.add(bgPanel);
        frame.add(p);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void show(int i) {
        frame.repaint();
        frame.revalidate();
    }

    public void setKeyListener(KeyListener kl) {
        this.frame.addKeyListener(kl);
    }

    @Override
    public void update() {
        for (ObjectView view : views) {
            view.update();
        }
        hud.update();

        for (GraphicBall view : ballsViews) {
            view.update();
        }
    }
}
