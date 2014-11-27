package com.grupo2.ghost;

import com.grupo2.character.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.ghostFactory.GhostFactory;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.grupo2.constants.Constants;

/**
 *
 * @author ivan
 */
public class GhostTest {

    Ghost ghost;

    public GhostTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Constants.setInitialVelocity((float) 1.0);
        ghost = GhostFactory.createOnlyRightGhost();
        Cell currCell = new Cell(0, 0, true);
        currCell.setLeftCell(new Cell(3, 0, false));
        currCell.setLowerCell(new Cell(0, 1, false));
        currCell.setUpperCell(new Cell(0, 3, false));
        currCell.setRightCell(new Cell(1, 0, true));
        ghost.setCurrentCell(currCell);
    }

    @Test
    public void move() {
        ghost.move();
        assertTrue(ghost.getPosition().isEqualTo(new Coordinate(1, 0)));
    }

    @Test
    public void TryingToKillHunterGhost() {
        try {
            ghost.die();
        } catch (AssertionError e) {
            assert (true);
        }
    }

    @Test
    public void TryingToKillPreyGhost() {
        ghost.convertToPrey();
        ghost.die();
        assertTrue(ghost.isDead());
    }

    @Test
    public void TryingToConvertADeadToPrey() {
        ghost.convertToPrey();
        ghost.die();
        try {
            ghost.convertToPrey();
        } catch (AssertionError e) {
            assert (true);
        }
    }
}
