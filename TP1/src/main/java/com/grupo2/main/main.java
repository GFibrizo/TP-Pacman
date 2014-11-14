package com.grupo2.main;

import com.grupo2.controller.Controller;
import com.grupo2.controller.KeyBoardReader;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.view.GraphicView;
import java.io.IOException;
import java.nio.file.Paths;
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
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
		RawMaze maze = mBuilder.buildMaze();
		KeyBoardReader kr = new KeyBoardReader();
		Controller controller = new Controller(kr);
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
		GraphicView view = new GraphicView(maze);
		view.setKeyListener(kr);
		view.drawMaze();
//            view.show();
		//Thread.sleep(20);
            /*int i= 0;
		 Cell a;
		 do {
		 a = (Cell) maze.getNodes().get(i);
		 i++;
		 } while (!a.isTransitable());                   //CODE FOR TEST
		 a.setBall(new BigBall());
		 view.drawMaze();
		 view.show();*/
	}

}
