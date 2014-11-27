package com.grupo2.scenarios;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.controller.Controller;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.Maze;
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
        //Constants.setInitialVelocity((float) 0.5);
        MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "LaberintoVacio.xml"));
        CharacterBuilder charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYHunter.xml"));
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
                System.out.print("Sale por el primero");
                break;
            }
            if (!theGhost.getPosition().isEqualTo(new Coordinate(10 - j, 1))) {
                System.out.print("Sale por el segundo");
                break;
            }
        }

        boolean OK = thePacman.getPosition().isEqualTo(new Coordinate(7, 1)) && (thePacman.isDead());
        System.out.print(theGhost.getPosition().getX());
        System.out.print(theGhost.getPosition().getY());
        //System.out.print();
        assertTrue(OK);

    }
}
