package com.grupo2.controller;

import com.grupo2.character.Direction;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.NullDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author ivan
 */
public class XMLReader implements InputReader {

    private Path dir;
    private Document doc;
    private int tickNumber;

    private void initializeDoc() throws SAXException, IOException, ParserConfigurationException {
		String filePath = "pacmanTick" + this.tickNumber + ".xml";
        File xmlFile = this.dir.resolve(filePath).toFile();
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        this.doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
    }

    public XMLReader(Path dir) throws SAXException, IOException, ParserConfigurationException {
        this.tickNumber = 1;
        this.dir = dir;
        this.initializeDoc();
    }

    @Override
    public Direction getNextDirection() {
        Direction dirRes = new NullDirection();
        try {
            Element root = doc.getDocumentElement();
            Element node = (Element) root.getFirstChild();
            String direccion = node.getAttribute("direccion");
            switch (direccion) {
                case "arriba":
					dirRes = new UpDirection();
					break;
                case "abajo":
					dirRes = new DownDirection();
					break;
                case "izquierda":
					dirRes = new LeftDirection();
					break;
                default:
                    dirRes = new RightDirection();
            }
            this.tickNumber++;
            this.initializeDoc();

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dirRes;
    }
}
