/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

import com.grupo2.character.directions.DownDirection;
import com.grupo2.character.directions.LeftDirection;
import com.grupo2.character.directions.RightDirection;
import com.grupo2.interfaces.ICharacter;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class DirectionTest {
    
    private LeftDirection aLeftDirection;
    private DownDirection aDownDirection;
    
    public DirectionTest() {
    }
    
    @Before
    public void setUp() {
        aLeftDirection = new LeftDirection();
        aDownDirection = new DownDirection();        
    }

    /**
     * Test of isEqualTo method, of class Direction.
     */
    @Test
    public void twoDirectionsAreTheSame() {

        boolean sameDirection = aLeftDirection.isEqualTo(aLeftDirection);
        assertTrue(sameDirection);
    }

    @Test
    public void twoDirectionsAreDifferent() {

        boolean sameDirection = aLeftDirection.isEqualTo(aDownDirection);
        assertFalse(sameDirection);
    }    
   
}
