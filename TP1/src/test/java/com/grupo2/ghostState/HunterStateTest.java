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
import com.grupo2.interfaces.IGhost;
import com.grupo2.ghost.Ghost;
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
        System.out.println("move");
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
        System.out.println("isDead");
        boolean expResult = false;
        boolean result = state.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class HunterState.
     */
    @Test
    public void testingReturnNextState() {
        System.out.println("returnNextState");
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
        System.out.println("convertToPrey");
        GhostState result = state.convertToPrey();
        assertEquals(result.getClass(), PreyState.class);
        assertFalse(result.isDead());
    }

    /**
     * Test of die method, of class HunterState.
     */
    @Test
    public void testDie() {
        System.out.println("die");
        boolean flag = false;
        try {
            GhostState result = state.die();
        } catch (AssertionError e) {
            flag = true;
        }
        assertTrue(flag);

    }
    
}
