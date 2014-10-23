package com.grupo2.game;

import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.XMLReader;
import com.grupo2.map.Map;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.view.View;
import com.grupo2.view.XMLView;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author mauri
 */
public class Game {

    //TODO: Builders should depend on pgm arguments or something like that
    public void startGame() throws ParserConfigurationException, SAXException, IOException {

        Map map = new Map(new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml")),
                new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml")));
        Path path = Paths.get("src", "main", "resources", "pacman");
        Controller controller = new Controller(new XMLReader(path));
        View view = new XMLView("vpath");
        boolean ended = false;

        while (!ended) {
            map.updateModel(controller);
            map.updateView(view);
        }
    }
}
