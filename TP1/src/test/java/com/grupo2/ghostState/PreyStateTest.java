package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.LeftDirection;
import com.grupo2.ghost.GhostState;
import com.grupo2.personality.Seeker;
import com.grupo2.pacman.Pacman;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fibrizo
 */
public class PreyStateTest {

    GhostState state;

    public PreyStateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Constants.setInitialVelocity((float) 1.0);
        state = new PreyState();
        Pacman pacman = Pacman.createPacman(0, 0, new LeftDirection(), new Cell(0, 0, true));
    }

    /**
     * Test of move method, of class PreyState.
     */
    @Test
    public void testMove() {
        Map<Direction, Cell> directions = new HashMap<>();
        directions.put(new LeftDirection(), new Cell(0, 0, false));
        Direction newDirection = state.getNewDirection(new Seeker(), directions);

        assertTrue(newDirection.isEqualTo(new LeftDirection()));
    }

    /**
     * Test of isDead method, of class PreyState.
     */
    @Test
    public void testIsDead() {
        boolean expResult = false;
        boolean result = state.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class DeadState.
     */
    @Test
    public void testingReturnNextState() {
        assertFalse(state.isDead());
        state = state.returnNextState();
        assertFalse(state.isDead());
        Constants.setPreyLimitTime((float) 0);
        state = state.returnNextState();
        assertEquals(state.getClass(), HunterState.class);
    }

    /**
     * Test of convertToPrey method, of class DeadState.
     */
    @Test
    public void testConvertToPrey() {
        assertFalse(state.isDead());
        assertTrue(state.convertToPrey().getClass() == PreyState.class);
    }

    /**
     * Test of die method, of class DeadState.
     */
    @Test
    public void testDie() {
        assertFalse(state.isDead());
        state = state.die();
        assertTrue(state.isDead());

    }

}
