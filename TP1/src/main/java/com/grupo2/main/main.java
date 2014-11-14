package com.grupo2.main;

import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.InputReader;
import com.grupo2.controller.XMLReader;
import com.grupo2.game.Game;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.view.DrawableNode;
import com.grupo2.view.GraphicView;
import com.grupo2.view.*;
import com.grupo2.view.XMLView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.grupo2.cell.Cell;
import com.grupo2.balls.BigBall;
import com.grupo2.board.Board;
import com.grupo2.graphicView.ViewsFactory;

/**
 *
 * @author ivan
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
            MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
            CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
            //RawMaze maze = mBuilder.buildMaze();
            /*ArrayList<DrawableNode> cells = maze.getNodes();
            
            JFrame frame = new JFrame("Pacman Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(48*maze.getWidth(),48*maze.getHeight());
            frame.setLocationRelativeTo(null);    
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
            frame.setVisible(true);*/
            Board board = Board.createBoard(mBuilder, cBuilder);
            
            GraphicView view = ViewsFactory.createGraphicView(board);
            view.drawAll();
            view.show();
            Thread.sleep(20);
            int i= 0;
            Cell a;
            do {
                a = (Cell) board.getMaze().getNodes().get(i);
                i++;
            } while (!a.isTransitable());                   //CODE FOR TEST
            a.setBall(new BigBall());
            view.drawAll();
            view.show();
	}

}
