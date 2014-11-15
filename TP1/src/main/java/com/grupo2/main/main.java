package com.grupo2.main;

import com.grupo2.balls.NullBall;
import com.grupo2.character.Coordinate;
import com.grupo2.controller.Controller;
import com.grupo2.controller.KeyBoardReader;
import com.grupo2.graphicView.Background;
import com.grupo2.graphicView.GraphicBigBall;
import com.grupo2.graphicView.GraphicLittleBall;
import com.grupo2.graphicView.GraphicNode;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.view.DrawableNode;
import com.grupo2.view.GraphicView;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JFrame;
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
            GraphicView view = new GraphicView(maze);
            
            view.drawMaze();
            maze.getCellFromCoordinates(new Coordinate(1,1)).setBall(new NullBall());      
            view.drawMaze();
            
	}

}
