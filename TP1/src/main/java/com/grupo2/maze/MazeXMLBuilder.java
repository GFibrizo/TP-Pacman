package com.grupo2.maze;

import com.grupo2.balls.Ball;
import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import com.grupo2.balls.NullBall;
import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.ViewConstants;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
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

/**
 *
 * @author ivan
 */
public class MazeXMLBuilder implements MazeBuilder {

	private final File xmlFile;
	Map<String, Function> hash;

	public MazeXMLBuilder(Path path) {
		this.xmlFile = path.toFile();
		hash = new HashMap<>();
		hash.put("bolita", (p) -> {
			return new LittleBall();
		});
		hash.put("bolon", (p) -> {
			return new BigBall();
		});
		hash.put("", (p) -> {
			return new NullBall();
		});
	}

	private Coordinate getCoords(String attribute) {
		int half = attribute.length() / 2;
		int x, y;
		y = Integer.parseInt(attribute.substring(0, half));
		x = Integer.parseInt(attribute.substring(half, 2 * half));

		return new Coordinate(x, y);
	}

	private boolean isUntransitableCell(Element eElement) {
		String[] cells = new String[]{"izquierda", "derecha", "arriba", "abajo"};
		for (String cell : cells) {
			if (!eElement.getAttribute(cell).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public RawMaze buildMaze() {
		RawMaze maze = null;
		try {
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc;
			doc = dBuilder.parse(this.xmlFile);
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			int width = Integer.parseInt(root.getAttribute("ancho"));
			int height = Integer.parseInt(root.getAttribute("alto"));
			Coordinate initPacman = this.getCoords(root.getAttribute("inicioPacman"));
			Coordinate initGhosts = this.getCoords(root.getAttribute("inicioFantasmas"));
			maze = new RawMaze(height, width, initPacman, initGhosts);

			width = Integer.parseInt(root.getAttribute("nodoAncho"));
			height = Integer.parseInt(root.getAttribute("nodoAlto"));
			maze.setNodeWidth(width);
			maze.setNodeHeight(height);
			ViewConstants.setDrawableHeight(height);
			ViewConstants.setDrawableWidth(width);

			NodeList nList = doc.getElementsByTagName("nodo");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					int y = Integer.parseInt(eElement.getAttribute("fila"));
					int x = Integer.parseInt(eElement.getAttribute("columna"));
					String content = eElement.getAttribute("contiene");

					Cell aCell;
					if (this.isUntransitableCell(eElement)) {
						aCell = new Cell(x, y, false);
					} else {
						aCell = new Cell(x, y, true);
						Ball ball = (Ball) hash.get(content).apply(null);
						aCell.setBall(ball);
					}
					maze.addCell(aCell);
				}
			}
			maze.connectCells();

		} catch (ParserConfigurationException | SAXException | IOException ex) {
			Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
		}
		return maze;
	}

}
