/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

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
public class CollidingAreaTest {
    
    float initialX;
    float initialY;
    float initialRadius;
    
    public CollidingAreaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        initialX = 1;
        initialY = 1;
        initialRadius = 1;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRadius method, of class CollidingArea.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        float rad = 5;
        CollidingArea area = new CollidingArea(1,1,rad);
        assertTrue(rad == area.getRadius());
    }

    /**
     * Test of setRadius method, of class CollidingArea.
     */
    @Test
    public void testSetRadius() {
        System.out.println("setRadius");
        float radius = 5;
        CollidingArea instance = new CollidingArea(initialX, initialY, initialRadius);
        instance.setRadius(radius);
        assertTrue(radius == instance.getRadius());
    }

    /**
     * Test of displaceHorizantally method, of class CollidingArea.
     */
    @Test
    public void testDisplaceHorizantally() {
        System.out.println("displaceHorizantally");
        float offset = 1;
        CollidingArea instance = new CollidingArea(initialX,initialY, initialRadius);
        instance.displaceHorizantally(offset);
        assertTrue(instance.obtainCoordinateX() == initialX+offset);
    }

    /**
     * Test of displaceVertically method, of class CollidingArea.
     */
    @Test
    public void testDisplaceVertically() {
        System.out.println("displaceVertically");
        float offset = 1;
        CollidingArea instance = new CollidingArea(initialX, initialY, initialRadius);
        instance.displaceVertically(offset);
        assertTrue(instance.obtainCoordinateY() == initialY+offset);
    }

    /**
     * Test of isCollindingWith method, of class CollidingArea.
     */
    @Test
    public void testIsCollindingWith() {
        System.out.println("isCollindingWith");
        float x1 = 4;
        float y1 = 1;
        float rad = 5;
        CollidingArea otherPosition = new CollidingArea(x1, y1, rad);
        CollidingArea instance = new CollidingArea(initialX, initialY, initialRadius);
        boolean expResult = true;
        boolean result = instance.isCollindingWith(otherPosition);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEqualTo method, of class CollidingArea.
     */
    @Test
    public void testIsEqualTo() {
        System.out.println("isEqualTo");
        CollidingArea otherPosition = new CollidingArea(initialX, initialY, initialRadius);
        CollidingArea instance = new CollidingArea(initialX, initialY, initialRadius);
        boolean expResult = true;
        boolean result = instance.isEqualTo(otherPosition);
        assertEquals(expResult, result);
    }
    
}
