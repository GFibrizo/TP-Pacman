package com.grupo2.scenarios;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.controller.Controller;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fibrizo
 */
public class ThirdScenarioTest {

    private Pacman thePacman;
    private Ghost theGhost;
    private Maze maze;
    private Board map;

    public ThirdScenarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParserConfigurationException {
        Constants.VISION1 = 12;
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "LaberintoVacio.xml"));
        CharacterBuilder charBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYHunter.xml"));
        map = Board.createBoard(mazeBuilder, charBuilder);
        theGhost = map.getGhosts().get(0);
        map.subscribeSubscribers();
        thePacman = map.getPacman();
        theGhost = map.getGhosts().get(0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PacmanMeetsHunterGhost() throws UnsupportedOperationException {

		Controller controller = new Controller(() -> new RightDirection());
        for (int i = 0; i < 8; i++) {
            map.updateModel(controller);
        }

		boolean result = thePacman.getPosition().isEqualTo(new Coordinate(8, 1)) && (thePacman.isDead());

		assertTrue(result);

    }
}