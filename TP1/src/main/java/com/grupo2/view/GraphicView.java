package com.grupo2.view;

import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicView extends View {

	private final JFrame frame;
	private ArrayList<GraphicNode> gNodes;
	private JPanel p;

	public GraphicView() {
            frame = new JFrame("Pacman Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(48*maze.getWidth(),48*maze.getHeight());
            frame.setLocationRelativeTo(null);   
	}

	@Override
	public void setMaze(DrawableMaze maze) {
		this.maze = maze;
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
                    if (cell.hasBigBall()) node.add(new GraphicBigBall(48,48,0,0));
                    if (cell.hasLittleBall()) node.add(new GraphicLittleBall(48,48,0,0));                
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
