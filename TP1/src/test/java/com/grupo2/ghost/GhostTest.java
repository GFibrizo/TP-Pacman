package com.grupo2.ghost;

import com.grupo2.cell.TransitableCell;
import com.grupo2.cell.UntransitableCell;
import com.grupo2.character.Coordinate;
import com.grupo2.ghostFactory.GhostFactory;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		ghost = GhostFactory.createOnlyRightGhost();
		TransitableCell currCell = new TransitableCell(0, 0);
		currCell.setLeftCell(new UntransitableCell(3, 0));
		currCell.setLowerCell(new UntransitableCell(0, 1));
		currCell.setUpperCell(new UntransitableCell(0, 3));
		currCell.setRightCell(new TransitableCell(1, 0));
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
