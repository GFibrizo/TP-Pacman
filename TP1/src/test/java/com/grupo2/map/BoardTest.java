package com.grupo2.map;

import com.grupo2.cell.Cell;
import com.grupo2.board.Board;
import com.grupo2.character.Character;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.MazeXMLBuilder;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of collisionBetween method, of class Board.
     */
    @Test
    public void testCollisionBetween() throws ParserConfigurationException {
        Character character = Ghost.createEmptyGhost();
        character.setCurrentCell(new Cell(0, 0, true));
        character.setDirection(new RightDirection());
        Character other = Ghost.createEmptyGhost();
        other.setCurrentCell(new Cell(0, 0, true));
        other.setDirection(new LeftDirection());
        Board map;
        map = new Board(new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml")), new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYHunter.xml")));
        boolean result = map.collisionBetween(character, other);

        assertTrue(result);
    }

}
