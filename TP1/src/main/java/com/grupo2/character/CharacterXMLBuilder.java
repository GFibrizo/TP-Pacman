package com.grupo2.character;

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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import com.grupo2.personality.*;
import com.grupo2.ghostState.*;
import com.grupo2.ghost.*;
import com.grupo2.interfaces.*;
import com.grupo2.directions.*;
import com.grupo2.ghostFactory.GhostFactory;



public class CharacterXMLBuilder implements CharacterBuilder {
    
    
    private String path;
    private DocumentBuilder dBuilder;
    private Document doc;
    Map<String, Function> hash = new HashMap<>();
    private ArrayList<IGhost> ghosts;
    private Pacman pacman;
        
        
       
    public CharacterXMLBuilder(String path) throws ParserConfigurationException {
        this.path = path;
        try {
            this.dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
            throw new ParserConfigurationException();
        }
        /*
        hash.put("izquierda", (p) -> {return new LeftDirection();});
        hash.put("derecha",   (p) -> {return new RightDirection();});
        hash.put("arriba",    (p) -> {return new UpDirection();});
        hash.put("abajo",     (p) -> {return new DownDirection();});
        hash.put("zonzo",     (p) -> {return new Dumb();});
        hash.put("buscador",  (p) -> {return new Seeker();});
        hash.put("perezoso",  (p) -> {return new Lazy();});
        hash.put("Cazador",   (p) -> {return new HunterState();});
        hash.put("Presa",     (p) -> {return new PreyState();});*/
    }
    
   
    /*private ICharacter constructCharacter(Element eElement, boolean isGhost) {
        int x = Integer.parseInt(eElement.getAttribute("fila"));
        int y = Integer.parseInt(eElement.getAttribute("columna"));
        Direction dir = (Direction) hash.get(eElement.getAttribute("sentido")).apply(null);

        if (!isGhost) {
            return new Pacman(x, y, dir);
        } else {
            Coordinate coord = new Coordinate(x,y);
            Personality pers = (Personality) hash.get(eElement.getAttribute("personalidad")).apply(null);
            GhostState state = (GhostState) hash.get(eElement.getAttribute("estado")).apply(null);
            return GhostFactory.createGhost(state, pers, coord, dir);   
        }
    }*/
    
    
    public void obtainCharactersFromXML() {
       /* try {
            File xmlFile = new File(path);
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
                    this.ghosts.add((Ghost) constructCharacter(eElement, false));
                }
            }
        } catch (SAXException | IOException ex) {
            Logger.getLogger(MazeXMLBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        

        
        try {
            System.out.print(path);
            File xmlFile = new File(path);
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            int x = Integer.parseInt(root.getAttribute("fila"));
            int y = Integer.parseInt(root.getAttribute("columna"));
            String direction = root.getAttribute("sentido");
            Direction dir;
            dir = getDirection(direction);
            this.pacman = Pacman.createPacman(x, y, dir);
            
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
                    Coordinate coord = new Coordinate(x,y);
                    this.ghosts.add(GhostFactory.createGhost(null, null, coord, dir)); 
                    //this.ghosts.add(new Ghost(x, y, dir));
                }
            }
        } catch ( SAXException | IOException ex) {
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
