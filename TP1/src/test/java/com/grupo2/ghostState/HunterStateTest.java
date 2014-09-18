/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;

import com.grupo2.character.IGhost;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghost.GhostState;
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
        boolean flag = false;
        try {
            state.move();
        } catch (UnsupportedOperationException e) {
            flag = true;
        }
        assertTrue(flag);
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
     * Test of beEaten method, of class DeadState.
     */
    @Test
    public void testBeEaten() {
        System.out.println("beEaten");
        IGhost ghost = new Ghost((float)1, (float)1);
        // Here soon will be a test that really tests something
        assertTrue(true);
        
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
