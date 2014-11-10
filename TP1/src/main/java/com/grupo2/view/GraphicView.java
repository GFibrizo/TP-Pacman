package com.grupo2.view;

import com.grupo2.graphicView.GraphicNode;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicView extends View {

	private final JFrame frame;
	private ArrayList<GraphicNode> gNodes;
	private JPanel p;

	public GraphicView() {
		this.frame = new JFrame("Pacman");
//		this.frame.setIconImage();
//		this.frame.add(new Background());
//		this.frame.pack();

//		this.frame.setVisible(true);
		this.frame.setSize(800, 600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.p = new JPanel(new GridLayout(19, 19));
		this.p.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}

	@Override
	public void setMaze(DrawableMaze maze) {
		this.maze = maze;
		int width = this.maze.getNodeWidth();
		int height = this.maze.getNodeHeight();
		this.maze.getNodes().forEach((dNode) -> {
//			this.gNodes.add(new GraphicNode(width, height, dNode.getCoords().getX(), dNode.getCoords().getY(), dNode.isTransitable()));
			this.p.add(new GraphicNode(width, height, dNode.getCoords().getX() * width, dNode.getCoords().getY() * height, dNode.isTransitable()));
		});

	}

	@Override
	public void show() {
		this.frame.add(p);
	}

}
