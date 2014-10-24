package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.controller.Controller;
import com.grupo2.directions.RightDirection;
import com.grupo2.map.Map;
import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author fibrizo
 */
public class SecondScenarioTest {

	private Pacman thePacman;
	private Maze maze;
	private Map map;

	public SecondScenarioTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws ParserConfigurationException {
		MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
		//thePacman = Pacman.createPacman(1, 2, new RightDirection(), m);
		map = new Map(mazeBuilder, new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintos", "PersonajesSimple.xml")));
	}

	@After
	public void tearDown() {
	}

	@Test
	public void PacmanEatsBallsAndRespectsPortals() {

		Controller controller = new Controller(() -> new RightDirection());
		for (int i = 1; i < 13; i++) {
			map.updateModel(controller);
		}

		int ballsEaten = 0;

		Cell cell = map.getMaze().getCellFromCoordinates(new Coordinate(1, 0));
		for (int i = 0; i < 12; i++) {
			if (cell.isEmpty()) {
				ballsEaten++;
				return;
			}
			cell = cell.getRightCell();
		}
		assert (true);

		Coordinate expectedPosition = new Coordinate(1, 4);
		boolean positionOK = expectedPosition.isEqualTo(thePacman.getPosition());

		assertTrue(positionOK && ballsEaten == 11);

	}
}
