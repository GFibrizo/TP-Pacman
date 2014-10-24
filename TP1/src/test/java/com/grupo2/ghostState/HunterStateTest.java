/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Direction;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.ghost.GhostState;
import com.grupo2.pacman.Pacman;
import com.grupo2.personality.Seeker;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
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
public class HunterStateTest {

    GhostState state;

    public HunterStateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        state = new HunterState();
    }

    @After
    public void tearDown() {
        state = null;
    }

    /**
     * Test of move method, of class HunterState.
     */
    @Test
    public void testMove() {
        Map<Direction, Cell> directions = new TreeMap<>();
        directions.put(new UpDirection(), new TransitableCell(5,5));
        directions.put(new LeftDirection(), new TransitableCell(5,4));
        Pacman.createPacman(5, 1, new UpDirection());
        Direction newDirection = state.getNewDirection(new Seeker(), directions);

        assertTrue(newDirection.isEqualTo(new LeftDirection()));
    }

    /**
     * Test of isDead method, of class HunterState.
     */
    @Test
    public void testIsDead() {
        boolean expResult = false;
        boolean result = state.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class HunterState.
     */
    @Test
    public void testingReturnNextState() {
        assertFalse(state.isDead());
        state = state.returnNextState();
        assertFalse(state.isDead());
        assertEquals(state.getClass(), HunterState.class);
    }

    /**
     * Test of convertToPrey method, of class HunterState.
     */
    @Test
    public void testConvertToPrey() {
		GhostState result = state.convertToPrey();
		System.out.println(result.getClass());
        assertEquals(result.getClass(), PreyState.class);
    }

    /**
     * Test of die method, of class HunterState.
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
