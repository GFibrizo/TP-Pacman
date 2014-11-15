package com.grupo2.view;

import com.grupo2.board.Board;
import com.grupo2.pacman.Pacman;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ivan
 */
public class XMLView extends View {

    private final Path directory;
    private int mazeTick;
    private int charTick;

    public XMLView(Path path) throws ParserConfigurationException {
        this.directory = path;

    }

    private void persistMaze() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("laberinto");
        int width = this.maze.getWidth();
        int height = this.maze.getHeight();
        rootElement.setAttribute("ancho", String.valueOf(width));
        rootElement.setAttribute("alto", String.valueOf(height));
        rootElement.setAttribute("nodoAncho", String.valueOf(this.maze.getNodeWidth()));
        rootElement.setAttribute("nodoAlto", String.valueOf(this.maze.getNodeHeight()));
        rootElement.setAttribute("inicioPacman", String.valueOf(this.maze.getPacmanBegining().getY())
                + String.valueOf(this.maze.getPacmanBegining().getX()));
        rootElement.setAttribute("inicioFantasmas", String.valueOf(this.maze.getGhostsBegining().getY())
                + String.valueOf(this.maze.getGhostsBegining().getX()));
        for (DrawableNode dNode : this.maze.getNodes()) {
            Element node = doc.createElement("nodo");
            int fila = dNode.getCoords().getY();
            int columna = dNode.getCoords().getX();
            node.setAttribute("id", String.valueOf(fila) + String.valueOf(columna));
            node.setAttribute("fila", String.valueOf(fila));
            node.setAttribute("columna", String.valueOf(columna));
            String content = dNode.hasBigBall() ? "bolon" : dNode.hasLittleBall() ? "bolita" : "";
            node.setAttribute("contiene", content);
            String neighbour;
            neighbour = dNode.isLeftTransitable() ? String.valueOf(fila) + String.valueOf((columna - 1 + width) % width) : "";
            node.setAttribute("izquierda", neighbour);
            neighbour = dNode.isRightTransitable() ? String.valueOf(fila) + String.valueOf((columna + 1) % width) : "";
            node.setAttribute("derecha", neighbour);
            neighbour = dNode.isUpTransitable() ? String.valueOf((fila - 1 + height) % height) + String.valueOf(columna) : "";
            node.setAttribute("arriba", neighbour);
            neighbour = dNode.isDownTransitable() ? String.valueOf((fila + 1) % height) + String.valueOf(columna) : "";
            node.setAttribute("abajo", neighbour);
            rootElement.appendChild(node);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(this.directory.resolve("LaberintoTick" + String.valueOf(this.mazeTick)).toFile());
        transformer.transform(source, result);
        this.mazeTick++;
    }

    private void persistCharacters() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("juego");
        int fila = Pacman.getPacman().getPosition().getY();
        int columna = Pacman.getPacman().getPosition().getX();
        rootElement.setAttribute("posicionPacman", String.valueOf(fila) + String.valueOf(columna));
        rootElement.setAttribute("fila", String.valueOf(fila));
        rootElement.setAttribute("columna", String.valueOf(columna));
        rootElement.setAttribute("sentido", String.valueOf(Pacman.getPacman().getDirection()));
        rootElement.setAttribute("puntaje", String.valueOf(Pacman.getPacman().getScore()));
        rootElement.setAttribute("finJuego", String.valueOf(!Pacman.getPacman().hasLives()));
        for (DrawableGhost dGhost : Board.getInstance().getGhosts()) {
            Element ghost = doc.createElement("fantasma");
            ghost.setAttribute("id", String.valueOf(dGhost.getNumber()));
            fila = dGhost.getPosition().getY();
            columna = dGhost.getPosition().getX();
            ghost.setAttribute("nodo", String.valueOf(fila) + String.valueOf(columna));
            ghost.setAttribute("fila", String.valueOf(fila));
            ghost.setAttribute("columna", String.valueOf(columna));
            ghost.setAttribute("sentido", String.valueOf(dGhost.getDirection()));
            ghost.setAttribute("personalidad", String.valueOf(dGhost.getPersonality()));
            ghost.setAttribute("estado", String.valueOf(dGhost.getState()));
            rootElement.appendChild(ghost);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(this.directory.resolve("PersonajesTick" + String.valueOf(this.charTick)).toFile());
        transformer.transform(source, result);
        this.charTick++;
    }

	@Override
    public void show(int i) {
        try {
            this.persistMaze();
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(XMLView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.persistCharacters();
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(XMLView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
