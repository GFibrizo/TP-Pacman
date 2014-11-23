package com.grupo2.maze;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import java.nio.file.Paths;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.grupo2.directions.LeftDirection;
import com.grupo2.character.Direction;

/**
 *
 * @author mauri
 */
public class MazeBuilderTest {

    private MazeXMLBuilder mazeBuilder;

    public MazeBuilderTest() {
    }

    @Before
    public void setUp() {
        mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
    }

    /**
     * Test of buildMaze method, of class MazeBuilder.
     */
    @Test
    public void buildMazeInitCharactersPositions() {
        // El builder no está parseando la altura ni ancho del xml. Ver.

        Maze maze = mazeBuilder.buildMaze();
        Coordinate ghostBeg = maze.getGhostBegining();
        Coordinate pacmanBeg = maze.getPacmanBegining();

        boolean ghostInitPositionOK = ghostBeg.isEqualTo(new Coordinate(0, 1));
        boolean pacmanInitPositionOK = pacmanBeg.isEqualTo(new Coordinate(2, 1));

        assertTrue(ghostInitPositionOK && pacmanInitPositionOK);
    }

    @Test
    public void buildMazeUnTransitableCell() {
        Maze maze = mazeBuilder.buildMaze();
        Cell cell = maze.getCellFromCoordinates(new Coordinate(0, 0));

        assertFalse(cell.isTransitable());
    }

    @Test
    public void buildMazeTransitableCell() {
        Maze maze = mazeBuilder.buildMaze();
        Cell cell = maze.getCellFromCoordinates(new Coordinate(2, 1));
        assertTrue(cell.isTransitable());
    }

    @Test
    public void buildMazeAndTravelIt() {
        Maze maze = mazeBuilder.buildMaze();
        Cell cell = maze.getCellFromCoordinates(new Coordinate(10, 1));
        int i = 0;
        while ((!cell.getPosition().isEqualTo(new Coordinate(0, 1))) && (i < 11)) {
            cell = cell.getLeftCell();
            System.out.print(i);
            i++;

        }

        assertTrue(cell.getPosition().isEqualTo(new Coordinate(0, 1)));
    }

}
