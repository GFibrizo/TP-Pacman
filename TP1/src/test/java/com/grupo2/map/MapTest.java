package com.grupo2.map;

import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.character.directions.DownDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.maze.MazeXMLBuilder;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class MapTest {

    public MapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of collisionBetween method, of class Map.
     */
    @Test
    public void testCollisionBetween() {
        ICharacter aCharacter = new Ghost(0, 0, new DownDirection());
        ICharacter anotherCharacter = new Ghost(0, 0, new DownDirection());
        Map map = new Map(new MazeXMLBuilder("path"), new CharacterXMLBuilder("otherpath"));
        boolean expResult = true;
        boolean result = map.collisionBetween(aCharacter, anotherCharacter);
        assertEquals(expResult, result);
    }

}
