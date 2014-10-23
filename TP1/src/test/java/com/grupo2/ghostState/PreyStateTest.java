/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;

import com.grupo2.cell.Cell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Direction;
import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.IGhost;
import com.grupo2.constants.Constants;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.UpDirection;
import com.grupo2.ghost.GhostState;
import com.grupo2.pacman.Pacman;
import com.grupo2.personality.Seeker;
import java.util.Map;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        state = new PreyState();
    }
    
    @After
    public void tearDown() {
        state = null;
    }

    /**
     * Test of move method, of class PreyState.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Map<Direction, Cell> directions = new TreeMap<>();
        Direction newDirection = state.getNewDirection(new Seeker(), directions);
 
        assertTrue(newDirection.isEqualTo(new LeftDirection()));
    }

    /**
     * Test of isDead method, of class PreyState.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        boolean expResult = false;
        boolean result = state.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class DeadState.
     */
    @Test
    public void testingReturnNextState() {
        System.out.println("returnNextState");
        assertFalse(state.isDead());
        state = state.returnNextState();
        assertFalse(state.isDead());
        Constants.setPreyLimitTime((float)0);
        state = state.returnNextState();
        assertEquals(state.getClass(), HunterState.class);
    }

    /**
     * Test of convertToPrey method, of class DeadState.
     */
    @Test
    public void testConvertToPrey() {
        System.out.println("convertToPrey");
        assertFalse(state.isDead());
        assertTrue(state.convertToPrey().getClass() == PreyState.class);
    }

    /**
     * Test of die method, of class DeadState.
     */
    @Test
    public void testDie() {
        System.out.println("die");
        assertFalse(state.isDead());
        state = state.die();
        assertTrue(state.isDead());

    }
    
}
