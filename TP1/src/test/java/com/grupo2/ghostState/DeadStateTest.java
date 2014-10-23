/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;

import com.grupo2.interfaces.IGhost;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.GhostState;
import com.grupo2.ghost.Ghost;
import com.grupo2.personality.Seeker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.grupo2.character.Direction;
import com.grupo2.cell.Cell;
import java.util.TreeMap;
import java.util.Map;
import com.grupo2.directions.*;
import com.grupo2.cell.*;
import com.grupo2.pacman.Pacman;

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
        System.out.println("move");
        Map<Direction, Cell> directions = new TreeMap<>();
        directions.put(new UpDirection(), new TransitableCell(5,5));
        directions.put(new LeftDirection(), new TransitableCell(5,4));
        Pacman.createPacman(5, 1, new UpDirection());
        Direction newDirection = state.getNewDirection(new Seeker(), directions);
 
        assertTrue(newDirection.isEqualTo(new LeftDirection()));
    }

    /**
     * Test of isDead method, of class DeadState.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        boolean expResult = true;
        boolean result = state.isDead();
        assertEquals(expResult, result);
    }

    /**
     * Test of returnNextState method, of class DeadState.
     */
    @Test
    public void testingReturnNextState() {
        System.out.println("returnNextState");
        assertTrue(state.isDead());
        state = state.returnNextState();
        assertTrue(state.isDead());
        assertTrue(state.isDead());
        Constants.setDeadLimitTime((float)0);
        state = state.returnNextState();
        assertEquals(state.getClass(), HunterState.class);
    }

    /**
     * Test of convertToPrey method, of class DeadState.
     */
    @Test
    public void testConvertToPrey() {
        System.out.println("convertToPrey");
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
