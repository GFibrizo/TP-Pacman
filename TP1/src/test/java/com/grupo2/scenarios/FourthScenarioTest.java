package com.grupo2.scenarios;

import com.grupo2.board.Board;
import com.grupo2.directions.LeftDirection;
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
 * @author mauri
 */
public class FourthScenarioTest {

    private Pacman thePacman;
    private Ghost theGhost;
    private Maze maze;
    private Board map;

    public FourthScenarioTest() {
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
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "LaberintoBolon.xml"));
        CharacterBuilder charBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYConvertido.xml"));
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
    public void HunterIsConvertedToPreyWhenPacmanEatsABall() {
        Controller controller = new Controller(() -> new RightDirection());
        int i = 0, j = 0;
        while (thePacman.getPosition().distanceTo(new Coordinate(4, 1)) > 0) {
            map.updateModel(controller);
            i++;
            if (i % 2 == 0) {
                j++;
            }
            if (!thePacman.getPosition().isEqualTo(new Coordinate(2 + i, 1))) {
                System.out.print("Sale por el primero");
                break;
            }
            if (!theGhost.getPosition().isEqualTo(new Coordinate(j, 1))) {
                System.out.print("Sale por el segundo");
                break;
            }
        }
        
        
        boolean OK0 = thePacman.getPosition().isEqualTo(new Coordinate(4, 1)); 
        boolean OK1 = theGhost.getPosition().isEqualTo(new Coordinate(1, 1));
        boolean OK2 = !thePacman.isDead();
        boolean OK3 = theGhost.getState().toString().compareTo("presa") == 0;
        
        controller = new Controller(() -> new LeftDirection());
        i = 0; 
        j = 0;
        while (thePacman.getPosition().distanceTo(theGhost.getPosition()) > 0) {
            map.updateModel(controller);
            i++;
            if (i % 2 == 0) {
                j++;
            }
            if (!thePacman.getPosition().isEqualTo(new Coordinate(4 - i, 1))) {
                System.out.print("Sale por el primero");
                break;
            }
            if (!theGhost.getPosition().isEqualTo(new Coordinate(1 - j, 1))) {
                System.out.print("Sale por el segundo");
                break;
            }
        }
        
        boolean OK4 = theGhost.isDead();
        boolean OK5 = thePacman.getPosition().isEqualTo(new Coordinate(10, 1));
        boolean OK6 = theGhost.getPosition().isEqualTo(new Coordinate(10, 1));        
        
        //System.out.print();
        assertTrue(OK0 == OK1 == OK2 == OK3 == OK4 == OK5 == OK6);

    }
    

}