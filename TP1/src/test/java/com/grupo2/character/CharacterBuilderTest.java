/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

import com.grupo2.character.directions.LeftDirection;
import com.grupo2.interfaces.IGhost;
import com.grupo2.pacman.Pacman;
import java.util.ArrayList;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class CharacterBuilderTest {

    private CharacterBuilder charBuilder;   
    
            public CharacterBuilderTest() {
    }
    
    @Before
    public void setUpClass() {
        charBuilder = new CharacterXMLBuilder("/home/mauri/Desktop/TDD/TPS/tp/TP1/src/main/resources/laberintos"); 
    }

    /**
     * Test of getPacman method, of class CharacterBuilder.
     */
    @Test
    public void getPacmanPosition() {
        
        System.out.println("getPacman TEST");
        Pacman builtPacman = charBuilder.getPacman();

        Coordinate builtPacPosition = builtPacman.getPosition();
        Direction builtPacDirection = builtPacman.getDirection();
        
        Coordinate expectedPacPosition = new Coordinate(4,9);
        Direction expectedPacDirection = new LeftDirection();
        
        boolean samePositions = expectedPacPosition.isEqualTo(builtPacPosition);
        boolean sameDirections = expectedPacDirection.isEqualTo(builtPacDirection);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGhosts method, of class CharacterBuilder.
     */
    @Test
    public void testGetGhosts() {
        System.out.println("getGhosts");
        CharacterBuilder instance = new CharacterBuilderImpl();
        ArrayList<IGhost> expResult = null;
        ArrayList<IGhost> result = instance.getGhosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
