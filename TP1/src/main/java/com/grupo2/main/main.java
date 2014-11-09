package com.grupo2.main;

import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.InputReader;
import com.grupo2.controller.XMLReader;
import com.grupo2.game.Game;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.view.GraphicView;
import com.grupo2.view.View;
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
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
		CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
		InputReader iReader = new XMLReader(Paths.get("src", "main", "resources", "pacman"));
//		View view = new XMLView(Paths.get("src", "main", "resources", "estados"));
		View view = new GraphicView();
		Game game = new Game(mBuilder, cBuilder, iReader, view);
		game.startGame();
//		JFrame frame = new JFrame();
////		frame.add(new JPanel());
//		frame.setSize(250, 200);
//		frame.setTitle("Application");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);

	}

}
