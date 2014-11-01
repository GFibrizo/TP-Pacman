package com.grupo2.game;

import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.controller.Controller;
import com.grupo2.controller.XMLReader;
import com.grupo2.interfaces.IGhost;
import com.grupo2.board.Board;
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

        Board map = new Board(new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "LaberintoSimple.xml")),
                new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml")));
        Path path = Paths.get("src", "main", "resources", "pacman");
        Controller controller = new Controller(new XMLReader(path));
		View view = new XMLView(Paths.get("src", "main", "resources", "estados"));
		view.setMaze(map.getMaze());
		view.setPacman(map.getPacman());
		map.getGhosts().forEach((IGhost ghost) -> {
			view.addGhost(ghost);
		});
        boolean ended = false;

        while (!ended) {
            map.updateModel(controller);
            map.updateView(view);
        }
    }
}
