package com.grupo2.scenarios;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.controller.Controller;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.MazeBuilder;
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
    private static Board map;

    public ThirdScenarioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ParserConfigurationException {
	Constants.restoreConstants();
	MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "LaberintoVacio.xml"));
	CharacterBuilder charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYHunter.xml"));
	map = Board.createBoard(mazeBuilder, charBuilder);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
	theGhost = map.getGhosts().get(0);
	map.subscribeSubscribers();
	thePacman = map.getPacman();
	theGhost = map.getGhosts().get(0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void PacmanMeetsHunterGhost() {

	Controller controller = new Controller(() -> new RightDirection());
	int i = 0, j = 0;
	while (!thePacman.isDead()) {
	    map.updateModel(controller);
	    i++;
	    if (i % 2 == 0) {
		j++;
	    }
	    if (!thePacman.getPosition().isEqualTo(new Coordinate(i, 1))) {
		break;
	    }
	    if (!theGhost.getPosition().isEqualTo(new Coordinate(10 - j, 1))) {
		break;
	    }
	}

	//Position is 0,1 because Pacman restarts his position when die
	boolean OK = thePacman.getPosition().isEqualTo(new Coordinate(0, 1)) && (thePacman.isDead());
	assertTrue(OK);

    }
}
