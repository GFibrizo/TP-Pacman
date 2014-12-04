package com.grupo2.ghost;

import com.grupo2.board.Board;
import com.grupo2.character.Cell;
import com.grupo2.character.CharacterBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.ghostFactory.GhostFactory;
import com.grupo2.maze.MazeBuilder;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
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
    public static void setUpClass() throws ParserConfigurationException {
	MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "Levels", "MazeLevel1" + ".xml"));
	CharacterBuilder charBuilder = new CharacterBuilder(Paths.get("src", "main", "resources", "Levels", "CharactersLevel1" + ".xml"));
	Board.createBoard(mazeBuilder, charBuilder);
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
