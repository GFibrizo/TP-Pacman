package com.grupo2.character;

import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghostFactory.GhostFactory;
import com.grupo2.ghostState.HunterState;
import com.grupo2.ghostState.Personality;
import com.grupo2.ghostState.PreyState;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.personality.Dumb;
import com.grupo2.personality.Lazy;
import com.grupo2.personality.Seeker;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
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

public class CharacterXMLBuilder implements CharacterBuilder {

    private Path path;
    private DocumentBuilder dBuilder;
    private Document doc;
    Map<String, Function> hash;
    private ArrayList<Ghost> ghosts;
    private Pacman pacman;

    public CharacterXMLBuilder(Path path) throws ParserConfigurationException {
        this.path = path;
        try {
            this.dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
            throw new ParserConfigurationException();
        }
        hash = new HashMap<>();
        hash.put("izquierda", (p) -> {
            return new LeftDirection();
        });
        hash.put("derecha", (p) -> {
            return new RightDirection();
        });
        hash.put("arriba", (p) -> {
            return new UpDirection();
        });
        hash.put("abajo", (p) -> {
            return new DownDirection();
        });
        hash.put("zonzo", (p) -> {
            return new Dumb();
        });
        hash.put("buscador", (p) -> {
            return new Seeker();
        });
        hash.put("perezoso", (p) -> {
            return new Lazy();
        });
        hash.put("cazador", (p) -> {
            return new HunterState();
        });
        hash.put("presa", (p) -> {
            return new PreyState();
        });
        this.obtainCharactersFromXML();
    }

    private Character constructCharacter(Element eElement, boolean isGhost) {
        int y = Integer.parseInt(eElement.getAttribute("fila"));
        int x = Integer.parseInt(eElement.getAttribute("columna"));
        Direction dir = (Direction) hash.get(eElement.getAttribute("sentido")).apply(null);

        if (!isGhost) {
            return Pacman.createPacman(x, y, dir, null);
        }

        Coordinate coord = new Coordinate(x, y);
        //System.out.print(hash.get(eElement.getAttribute("personalidad")).apply(null).getClass().toString());
        Personality pers = (Personality) hash.get(eElement.getAttribute("personalidad")).apply(null);
        GhostState state = (GhostState) hash.get(eElement.getAttribute("estado")).apply(null);
        return GhostFactory.createGhost(state, pers, coord, dir);
    }

    private void obtainCharactersFromXML() {
        try {
            File xmlFile = path.toFile();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            this.pacman = (Pacman) constructCharacter(root, false);
            NodeList nList = doc.getElementsByTagName("fantasma");
            this.ghosts = new ArrayList<>();
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    this.ghosts.add((Ghost) constructCharacter(eElement, true));
                }
            }
        } catch (SAXException | IOException ex) {
            Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
         //System.out.print(path);
         File xmlFile = path.toFile();
         doc = dBuilder.parse(xmlFile);
         doc.getDocumentElement().normalize();
         Element root = doc.getDocumentElement();
         int x = Integer.parseInt(root.getAttribute("fila"));
         int y = Integer.parseInt(root.getAttribute("columna"));
         String direction = root.getAttribute("sentido");
         Direction dir;
         dir = getDirection(direction);
         this.pacman = Pacman.createPacman(x, y, dir, null);

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
         Coordinate coord = new Coordinate(x, y);
         this.ghosts.add(GhostFactory.createGhost(null, null, coord, dir));
         //this.ghosts.add(new Ghost(x, y, dir));
         }
         }
         } catch (SAXException | IOException ex) {
         Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }*/
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
    public ArrayList<Ghost> getGhosts() {
        return this.ghosts;
    }

}
