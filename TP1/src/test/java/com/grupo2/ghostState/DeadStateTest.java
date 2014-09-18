/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.ghostState;

import com.grupo2.character.IGhost;
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
public class DeadStateTest {
    
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
        DeadState instance = new DeadState();
        try {
            instance.move();
        } catch (UnsupportedOperationException e) {
            assert(true);
        }
    }

    /**
     * Test of isDead method, of class DeadState.
     */
    @Test
    public void testIsDead() {
        System.out.println("isDead");
        DeadState instance = new DeadState();
        boolean expResult = false;
        boolean result = instance.isDead();
        assertEquals(expResult, result);

    }

    /**
     * Test of returnNextState method, of class DeadState.
     */
    @Test
    public void testReturnNextState() {
        System.out.println("returnNextState");
        DeadState instance = new DeadState();
        GhostState expResult = null;
        GhostState result = instance.returnNextState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of beEaten method, of class DeadState.
     */
    @Test
    public void testBeEaten() {
        System.out.println("beEaten");
        IGhost ghost = null;
        DeadState instance = new DeadState();
        instance.beEaten(ghost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToPrey method, of class DeadState.
     */
    @Test
    public void testConvertToPrey() {
        System.out.println("convertToPrey");
        DeadState instance = new DeadState();
        GhostState expResult = null;
        GhostState result = instance.convertToPrey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of die method, of class DeadState.
     */
    @Test
    public void testDie() {
        System.out.println("die");
        DeadState instance = new DeadState();
        GhostState expResult = null;
        GhostState result = instance.die();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
