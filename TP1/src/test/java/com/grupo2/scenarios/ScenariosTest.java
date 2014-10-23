/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.cell.TransitableCell;
import com.grupo2.character.Coordinate;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.ghost.Ghost;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import com.grupo2.pacman.Pacman;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import com.grupo2.ghostFactory.GhostFactory;
import com.grupo2.directions.RightDirection;

/**
 *
 * @author mauri
 */
public class ScenariosTest {
    private Pacman thePacman;
    private MazeXMLBuilder mazeBuilder;
    private Ghost anOnlyRightGhost;
    
    public ScenariosTest() {
    }

    @Before
    public void setUp() {
        mazeBuilder = new MazeXMLBuilder("/home/mauri/Desktop/TDD/TPS/tp/TP1/src/main/resources/laberintosprueba/Laberinto.xml");
        RawMaze maze = mazeBuilder.buildMaze();
        //anOnlyRightGhost = Ghost.createOnlyRightGhost();
        anOnlyRightGhost = GhostFactory.createOnlyRightGhost();
        Cell initialGhostCell = maze.getCellFromCoordinates(new Coordinate(1,1));        
        anOnlyRightGhost.setCurrentCell(initialGhostCell);
        thePacman = Pacman.createPacman(1, 2, new RightDirection());

    }
    
    @Test
    public void GhostShouldMoveTwelvePositions() {

        for (int i = 1; i < 12; i++) {
            anOnlyRightGhost.move();           
        }

        Coordinate expectedPosition = new Coordinate(1,2); //DECIA (1,1) estaba MAL
        boolean positionOK = expectedPosition.isEqualTo(anOnlyRightGhost.getPosition());
        
        assertTrue(positionOK);
    
    } 
    
    
    
    
    @Test void PacmanEatsBallsAndRespectsPortals() {
        
        for (int i = 1; i < 13; i++) {
            thePacman.move();           
        }
        
        //DO CHECK FOR EATEN BALLS
        
        Coordinate expectedPosition = new Coordinate(1,4);
        boolean positionOK = expectedPosition.isEqualTo(thePacman.getPosition());
        
        assertTrue(positionOK);
        
        
        
    }
    
}
