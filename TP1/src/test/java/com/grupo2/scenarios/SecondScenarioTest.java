/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import com.grupo2.directions.RightDirection;
import com.grupo2.maze.MazeXMLBuilder;
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
import com.grupo2.controller.*;

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
        map = new Map(mazeBuilder, thePacman);
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void PacmanEatsBallsAndRespectsPortals() {

        Controller controller = new Controller(new MockReader());
        for (int i = 1; i < 13; i++) {
            map.updateModel(controller);
        }

        Cell cell = map.getMaze().getCellFromCoordinates(new Coordinate(1,0));
        for (int i = 0; i < 12; i++) {
            if (!cell.isEmpty()) {
                assert(false);
                return;
            }
            cell = cell.getRightCell();
        }
        assert(true);
        
        
        Coordinate expectedPosition = new Coordinate(1,4);
        boolean positionOK = expectedPosition.isEqualTo(thePacman.getPosition());

        assertTrue(positionOK);
         
    }
    // @Test
    // public void hello() {}
}
