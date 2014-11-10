/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.fruit;

import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.maze.RawMaze;
import java.nio.file.Paths;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
        
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "Laberinto.xml"));
        RawMaze maze = mazeBuilder.buildMaze();        
        aCherry = new Cherry(maze);   
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void initialPositionOK() {
        
        System.out.println( aCherry.getCurrentCell().getCoords().getX() );
        System.out.println( aCherry.getCurrentCell().getCoords().getY() );        
        assertTrue(aCherry.getCurrentCell().isTransitable());
        
    }    
    
    @Test
    public void oneTickMovement() {
        
        int initialPosX = aCherry.getPosition().getX();
        aCherry.move();
        int afterMovementPosX = aCherry.getPosition().getX();        
        assertTrue(afterMovementPosX == initialPosX-1 || afterMovementPosX == initialPosX+1 );        
        
    }    
    
}
