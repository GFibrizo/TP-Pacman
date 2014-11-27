package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.ghost.Ghost;
import com.grupo2.ghostFactory.GhostFactory;
import com.grupo2.maze.MazeBuilder;
import com.grupo2.maze.Maze;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class FirstScenarioTest {

    private Pacman thePacman;
    private MazeBuilder mazeBuilder;
    private Ghost anOnlyRightGhost;

    public FirstScenarioTest() {
    }

    @Before
    public void setUp() {
        Constants.setInitialVelocity(1);
        mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
        Maze maze = mazeBuilder.buildMaze();
        //anOnlyRightGhost = Ghost.createOnlyRightGhost();
        anOnlyRightGhost = GhostFactory.createOnlyRightGhost();
        Cell initialGhostCell = maze.getCellFromCoordinates(new Coordinate(0, 1));
        anOnlyRightGhost.setCurrentCell(initialGhostCell);
    }

    @Test
    public void GhostShouldMoveTwelvePositions() {

        for (int i = 0; i < 12; i++) {
            anOnlyRightGhost.move();
        }

        Coordinate expectedPosition = new Coordinate(1, 1); //DECIA (1,1) estaba MAL
        boolean positionOK = expectedPosition.isEqualTo(anOnlyRightGhost.getPosition());
        System.out.print(anOnlyRightGhost.getPosition().getX());
        System.out.print(anOnlyRightGhost.getPosition().getY());
        assertTrue(positionOK);

    }

}
