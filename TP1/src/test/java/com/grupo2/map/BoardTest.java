package com.grupo2.map;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.directions.DownDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.maze.MazeXMLBuilder;
import java.nio.file.Paths;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
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
    public void testCollisionBetween() {
        ICharacter character = Ghost.createEmptyGhost();
        character.setPosition(0, 0);
        character.setDirection(new DownDirection());
        ICharacter other = Ghost.createEmptyGhost();
        other.setPosition(0, 0);
        other.setDirection(new DownDirection());
        Board map;
        try {
            map = new Board(new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml")),
                    new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml")));
        } catch (Exception e) {
            assert (false);
            return;
        }
        boolean expResult = true;
        boolean result = map.collisionBetween(character, other);
        assertEquals(expResult, result);
    }

}
