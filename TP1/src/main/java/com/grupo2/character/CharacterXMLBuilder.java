package com.grupo2.character;

import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.IGhost;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CharacterXMLBuilder implements CharacterBuilder {

	private ArrayList<IGhost> ghosts;
	private Pacman pacman;
	private final File xmlFile;

	public CharacterXMLBuilder(String path) {
		this.xmlFile = new File(path);

		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc;
			doc = dBuilder.parse(this.xmlFile);
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			int x = Integer.parseInt(root.getAttribute("fila"));
			int y = Integer.parseInt(root.getAttribute("columna"));
			String direction = root.getAttribute("sentido");
			Direction dir;
			dir = getDirection(direction);
			this.pacman = new Pacman(x, y, dir);
			NodeList nList = doc.getElementsByTagName("fantasma");
			this.ghosts = new ArrayList<>();
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					x = Integer.parseInt(eElement.getAttribute("fila"));
					y = Integer.parseInt(eElement.getAttribute("columna"));
					direction = eElement.getAttribute("sentido");
					dir = getDirection(direction);
					this.ghosts.add(new Ghost(x, y, dir));
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private Direction getDirection(String direction) {
		Direction dir;
		switch (direction) {
			case "izquierda":
				dir = new LeftDirection();
				break;
			case "derecha":
				dir = new RightDirection();
				break;
			case "abajo":
				dir = new DownDirection();
				break;
			default:
				dir = new UpDirection();
				break;
		}
		return dir;
	}

	@Override
	public Pacman getPacman() {
		return this.pacman;
	}

	@Override
	public ArrayList<IGhost> getGhosts() {
		return this.ghosts;
	}

}
