/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.character;

import com.grupo2.directions.LeftDirection;
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
            // CHANGE THE PATH TO YOURS
        charBuilder = new CharacterXMLBuilder("/home/mauri/Desktop/TDD/TPS/tp/TP1/src/main/resources/laberintos/PersonajesSimple.xml"); 
    }

    /**
     * Test of getPacman method, of class CharacterBuilder.
     */
    @Test
    public void getPacmanPosition() {
        
       Pacman builtPacman = charBuilder.getPacman();

        Coordinate builtPacPosition = builtPacman.getPosition();
        Direction builtPacDirection = builtPacman.getDirection();
        
        Coordinate expectedPacPosition = new Coordinate(4,9);
        LeftDirection expectedPacDirection = new LeftDirection();
        
        boolean samePositions = builtPacPosition.isEqualTo(expectedPacPosition);
        boolean sameDirections = builtPacDirection.isEqualTo(expectedPacDirection);
        
        assertTrue(sameDirections && samePositions);
    }
}