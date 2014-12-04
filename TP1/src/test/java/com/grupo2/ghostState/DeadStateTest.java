package com.grupo2.ghostState;

import com.grupo2.board.Board;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.GhostState;
import com.grupo2.maze.MazeBuilder;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fibrizo
 */
public class DeadStateTest {

    GhostState state;

    public DeadStateTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ParserConfigurationException {
	MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "Levels", "MazeLevel1" + ".xml"));
	CharacterBuilder charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "Levels", "CharactersLevel1" + ".xml"));
	Board.createBoard(mazeBuilder, charBuilder);
    }

    @Before
    public void setUp() {
	state = new DeadState();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isDead method, of class DeadState.
     */
    @Test
    public void testIsDead() {
	boolean expResult = true;
	boolean result = state.isDead();
	assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class DeadState.
     */
    @Test
    public void testingReturnNextState() {
	assertTrue(state.isDead());
	state = state.returnNextState();
	assertTrue(state.isDead());
	Constants.setDeadLimitTime((float) 0);
	state = state.returnNextState();
	assertEquals(state.getClass(), HunterState.class);
    }

    /**
     * Test of convertToPrey method, of class DeadState.
     */
    @Test
    public void testConvertToPrey() {
	GhostState result = state.convertToPrey();
	assertEquals(state.getClass(), result.getClass());
    }

    /**
     * Test of die method, of class DeadState.
     */
    @Test
    public void testDie() {
	GhostState result = state.die();
	assertEquals(state.getClass(), result.getClass());
    }

}
