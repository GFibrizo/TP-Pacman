/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.map;

import com.grupo2.ghost.Ghost;
import com.grupo2.interfaces.ICharacter;
import com.grupo2.map.Map;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class MapTest {
    
    public MapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of collisionBetween method, of class Map.
     */
    @Test
    public void testCollisionBetween() {
        ICharacter aCharacter = new Ghost(0,0);
        ICharacter anotherCharacter = new Ghost(0,0);
        Map instance = Map.getInstance();
        boolean expResult = true;
        boolean result = instance.collisionBetween(aCharacter, anotherCharacter);
        assertEquals(expResult, result);
    }
    
}
