package com.grupo2.view;

import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.grupo2.maze.Maze;

public class GraphicView extends View {

    private JFrame frame;
    private ArrayList<GraphicNode> gNodes;
    private JPanel p;
    
    
    private GraphicView(Maze maze) {
        this.frame = new JFrame("Pacman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(48*maze.getWidth(),48*maze.getHeight());
        frame.setLocationRelativeTo(null);
        this.maze = maze;
    }
    

    public static GraphicView createGraphicView(Maze maze) {
        return new GraphicView(maze);
    }

    
    public void drawAll() {
        frame.dispose();
        drawMaze();
        for (ObjectView view : views)
            view.repaint();
    }
    
    

    public void drawMaze() {
        ArrayList<DrawableNode> cells = this.maze.getNodes();
        Background bgPanel = new Background();            
        bgPanel.setLayout(new GridLayout(19,19));            
        JPanel ballsPanel = new JPanel();
        ballsPanel.setPreferredSize(new Dimension(912,912));
        ballsPanel.setLayout(new GridLayout(19,19));
        cells.forEach((cell) -> {

           boolean transitable = cell.isTransitable();
           GraphicNode node = new GraphicNode(48,48,0,0,transitable);

           if (transitable) {
                if (cell.hasBigBall()) node.add(new GraphicBigBall((BigBall)cell.getBall(),0,0));
                if (cell.hasLittleBall()) node.add(new GraphicLittleBall((LittleBall)cell.getBall(),0,0));                
            }
            bgPanel.add(node);                

        });            


        frame.add(bgPanel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void show() {
        this.frame.add(p);
    }

}
