/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.maze;

import com.grupo2.cell.Cell;
import com.grupo2.character.Coordinate;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
        mazeBuilder = new MazeXMLBuilder("/home/ivan/Escritorio/TP-TDD/tp/TP1/src/main/resources/laberintos/LaberintoSimple.xml");
    }
    
     /**
     * Test of buildMaze method, of class MazeBuilder.
     */
    @Test
    public void buildMazeInitCharactersPositions() {
        // El builder no está parseando la altura ni ancho del xml. Ver.
                
        RawMaze maze = mazeBuilder.buildMaze();
        Coordinate ghostBeg = maze.getGhostBegining();
        Coordinate pacmanBeg = maze.getPacmanBegining();
        
        boolean ghostInitPositionOK = ghostBeg.isEqualTo( new Coordinate(8,9) );
        boolean pacmanInitPositionOK = pacmanBeg.isEqualTo( new Coordinate(4,8) );
    
        assertTrue(ghostInitPositionOK && pacmanInitPositionOK);
    }
    
    @Test
    public void buildMazeTransitableCell() {
        RawMaze maze = mazeBuilder.buildMaze();
        Cell cell = maze.getCellFromCoordinates( new Coordinate(0,0) );

        assertFalse( cell.isTransitable() );
    }
        
}
