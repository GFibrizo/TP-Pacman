/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.pacman;

import com.grupo2.cell.RawCell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Coordinate;
import com.grupo2.character.Direction;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.UpDirection;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class PacmanTest {
    
    private Pacman thePacman;    
    
    public PacmanTest() {
    }
    
    @Before
    public void setUp() {
        thePacman = Pacman.createPacman(5,1,new LeftDirection());
        TransitableCell cell = new TransitableCell(5,1);
        cell.setLeftCell(new TransitableCell(4,1));
        cell.setRightCell(new TransitableCell(6,1));
        cell.setUpperCell(new TransitableCell(5,0));
        cell.setLowerCell(new TransitableCell(5,2));        
        thePacman.setCurrentCell(cell);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of move method, of class Pacman.
     */
    @Test
    public void shouldMoveLeftOneStep() {
        thePacman.move();
        int positionXResult = thePacman.getPosition().getX();
        assertEquals(4,positionXResult);
    }

    @Test
    public void shouldMoveLeftTwoSteps() {
        thePacman.move();
        thePacman.move();
        int positionXResult = thePacman.getPosition().getX();
        assertEquals(3,positionXResult);
    }
    
    /**
     * Test of isDead method, of class Pacman.
     */
    @Test
    public void isDead() {
        boolean result = thePacman.isDead();
        assertEquals(false, result);
    }

    /**
     * Test of changeDirection method, of class Pacman.
     */
    @Test
    public void changeDirectionToUpAndStep() {
        thePacman.setDirection(new UpDirection());
        thePacman.move();
        int positionYResult = thePacman.getPosition().getY();
        assertEquals(0,positionYResult);
    }
    
        @Test
    public void changeDirectionAndStepTwice() {
        thePacman.setDirection(new UpDirection());
        thePacman.move();
        thePacman.setDirection(new LeftDirection());
        thePacman.move();        
        Coordinate positionResult = thePacman.getPosition();
        boolean newPositionOK = positionResult.isEqualTo(new Coordinate(4,0));
        assertTrue(newPositionOK);
    }
   
}
