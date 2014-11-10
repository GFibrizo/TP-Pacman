package com.grupo2.main;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
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
//		MazeBuilder mBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml"));
//		CharacterBuilder cBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml"));
//		InputReader iReader = new XMLReader(Paths.get("src", "main", "resources", "pacman"));
////		View view = new XMLView(Paths.get("src", "main", "resources", "estados"));
//		View view = new GraphicView();
//		Game game = new Game(mBuilder, cBuilder, iReader, view);
//		game.startGame();
		JFrame frame = new JFrame();
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
		frame.pack();
	}

}
