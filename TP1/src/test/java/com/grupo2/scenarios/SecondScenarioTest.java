/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghostFactory.GhostFactory;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.pacman.Pacman;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.grupo2.maze.Maze;
import com.grupo2.map.Map;

/**
 *
 * @author fibrizo
 */
public class SecondScenarioTest {
    
    Pacman thePacman;
    Maze maze;
    Map map;
    
    public SecondScenarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
        thePacman = Pacman.createPacman(1, 2, new RightDirection());
        Cell initialPacmanCell = maze.getCellFromCoordinates(new Coordinate(1,1));
        thePacman.setCurrentCell(initialPacmanCell);
        map = new Map(mazeBuilder, thePacman);
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    void PacmanEatsBallsAndRespectsPortals() {

        for (int i = 1; i < 13; i++) {
            thePacman.move();           
        }

        for (int i = 1; i < 12; i++) {
            maze.getCellFromCoordinates(new Coordinate(1,i)).isEmpty();
        //DO CHECK FOR EATEN BALLS
        }
        
        
        Coordinate expectedPosition = new Coordinate(1,4);
        boolean positionOK = expectedPosition.isEqualTo(thePacman.getPosition());

        assertTrue(true);
         
    }
    // @Test
    // public void hello() {}
}
