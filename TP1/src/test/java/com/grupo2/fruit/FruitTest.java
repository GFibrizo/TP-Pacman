package com.grupo2.fruit;

import com.grupo2.maze.Maze;
import com.grupo2.maze.MazeBuilder;
import java.nio.file.Paths;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class FruitTest {

    private Fruit aCherry;

    public FruitTest() {
    }

    @Before
    public void setUp() {

	MazeBuilder mazeBuilder = new MazeBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
	Maze maze = mazeBuilder.buildMaze();
	aCherry = new Cherry(maze);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void initialPositionOK() {
	assertTrue(aCherry.getCurrentCell().isTransitable());

    }

    @Test
    public void oneTickMovement() {
	int initialPosX = aCherry.getPosition().getX();
	boolean moved = aCherry.move();
	while (!moved) {
	    moved = aCherry.move();
	}

	int afterMovementPosX = aCherry.getPosition().getX();
	assertTrue((afterMovementPosX == initialPosX - 1) || (afterMovementPosX == initialPosX + 1));

    }

}
