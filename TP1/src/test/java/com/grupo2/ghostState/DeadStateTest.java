package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Direction;
import com.grupo2.constants.Constants;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.ghost.GhostState;
import com.grupo2.pacman.Pacman;
import com.grupo2.personality.Seeker;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
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
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        state = new DeadState();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class DeadState.
     */
    @Test
    public void testMove() {
        Map<Direction, Cell> directions = new HashMap<>();
        directions.put(new UpDirection(), new TransitableCell(5, 4));
        directions.put(new LeftDirection(), new TransitableCell(4, 5));
        Pacman.createPacman(5, 5, new UpDirection(), new TransitableCell(5, 5));
        Direction newDirection = state.getNewDirection(new Seeker(), directions);

        assertTrue(newDirection.isEqualTo(new LeftDirection()));
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
        boolean flag = false;
        try {
            GhostState result = state.convertToPrey();
        } catch (AssertionError e) {
            flag = true;
        }
        assertTrue(flag);
    }

    /**
     * Test of die method, of class DeadState.
     */
    @Test
    public void testDie() {
        boolean flag = false;
        try {
            GhostState result = state.die();
        } catch (AssertionError e) {
            flag = true;
        }
        assertTrue(flag);

    }

}
