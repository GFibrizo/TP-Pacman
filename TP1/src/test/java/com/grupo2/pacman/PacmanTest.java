package com.grupo2.pacman;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.UpDirection;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
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
        Cell cell51 = new Cell(5, 1, true);
        Cell cell41 = new Cell(4, 1, true);
        Cell cell50 = new Cell(5, 0, true);
        thePacman = Pacman.createPacman(5, 1, new LeftDirection(), cell51);
        // Here we link the cells manually
        cell50.setLeftCell(new Cell(4, 0, true));
        cell41.setLeftCell(new Cell(3, 1, true));
        cell51.setLeftCell(cell41);
        cell51.setRightCell(new Cell(6, 1, true));
        cell51.setUpperCell(cell50);
        cell51.setLowerCell(new Cell(5, 2, true));

        thePacman.setCurrentCell(cell51);
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
        assertEquals(4, positionXResult);
    }

    @Test
    public void shouldMoveLeftTwoSteps() {
        thePacman.move();
        thePacman.move();
        int positionXResult = thePacman.getPosition().getX();
        assertEquals(3, positionXResult);
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
        assertEquals(0, positionYResult);
    }

    @Test
    public void changeDirectionAndStepTwice() {
        thePacman.setDirection(new UpDirection());
        thePacman.move();
        thePacman.setDirection(new LeftDirection());
        thePacman.move();
        Coordinate positionResult = thePacman.getPosition();
        boolean newPositionOK = positionResult.isEqualTo(new Coordinate(4, 0));
        assertTrue(newPositionOK);
    }

}
