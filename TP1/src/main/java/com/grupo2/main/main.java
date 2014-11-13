package com.grupo2.main;

import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.InputReader;
import com.grupo2.controller.XMLReader;
import com.grupo2.game.Game;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.view.DrawableNode;
import com.grupo2.view.GraphicView;
import com.grupo2.view.View;
import com.grupo2.view.XMLView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
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
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ivan
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
            MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
            RawMaze maze = mBuilder.buildMaze();
            ArrayList<DrawableNode> cells = maze.getNodes();
            
            JFrame frame = new JFrame("Pacman Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(48*maze.getWidth(),48*maze.getHeight());
            frame.setLocationRelativeTo(null);    
            //frame.setLayout(new GridLayout(19,19));
            Background bgPanel = new Background();            
            bgPanel.setLayout(new GridLayout(19,19));
            
            cells.forEach((cell) -> {
                boolean transitable = cell.isTransitable();
                bgPanel.add(new GraphicNode(48,48,0,0,transitable));                
            });
            
            frame.add(bgPanel);
            
            frame.pack();
            frame.setVisible(true);
                //CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
		//InputReader iReader = new XMLReader(Paths.get("src", "main", "resources", "pacman"));
		//View view = new XMLView(Paths.get("src", "main", "resources", "estados"));
		//View view = new GraphicView();
		//Game game = new Game(mBuilder, cBuilder, iReader, view);
		//game.startGame();
   
            
            
		/*JFrame frame = new JFrame();
		JPanel p = new JPanel(new GridLayout(19, 19));
		p.setComponentOrientation(ComponentOrientation.UNKNOWN);

		frame.setSize(800, 600);
		frame.setTitle("Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		ImageIcon boardBackground = new ImageIcon(Paths.get("src", "main", "graphicResources", "wallCell.png").toString());
		JLabel l = new JLabel(boardBackground);
		l.setBounds(0, 0, 60, 60);
		p.add(l);
		l = new JLabel(boardBackground);
		l.setBounds(160, 60, 60, 60);
		p.add(l);

		p.setBounds(0, 0, 800, 600);
		p.setSize(800, 600);
		frame.getContentPane().add(p);
		frame.pack();*/
        

        /*GraphicNode cell = new GraphicNode(48,48,0,0,false);
        GraphicNode cell2 = new GraphicNode(48,48,0,0,false);        

       
        bgPanel.add(cell);
        bgPanel.add(cell2);  

        frame.add(bgPanel); */


  
            

	}

}
