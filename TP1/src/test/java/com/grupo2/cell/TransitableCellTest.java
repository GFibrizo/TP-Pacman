/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.cell;

import com.grupo2.balls.Ball;
import com.grupo2.balls.BigBall;
import com.grupo2.balls.LittleBall;
import com.grupo2.character.Collitionable;
import com.grupo2.character.Coordinate;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class TransitableCellTest {

    TransitableCell transCell;
    
    public TransitableCellTest() {
    }
    
    @BeforeClass
    public void setUp() {
       
        TransitableCell transCell = new TransitableCell(2,2);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * Test of isTransitable method, of class TransitableCell.
     */
    @Test
    public void testIsTransitable() {

        boolean result = transCell.isTransitable();
        assertTrue(result);
    }

    /**
     * Test of isTheSame method, of class TransitableCell.
     */
    @Test
    public void testIsTheSame() {
        
        boolean result = transCell.isTheSame(transCell);
        assertTrue(result);
    }
    
}
