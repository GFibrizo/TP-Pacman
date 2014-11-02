/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.scenarios;

import com.grupo2.cell.Cell;
import com.grupo2.character.CharacterXMLBuilder;
import com.grupo2.character.Coordinate;
import com.grupo2.directions.RightDirection;
import com.grupo2.maze.MazeXMLBuilder;
import com.grupo2.pacman.Pacman;
import com.grupo2.ghost.Ghost;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.grupo2.maze.Maze;
import com.grupo2.board.Board;
import com.grupo2.controller.*;
import com.grupo2.character.CharacterBuilder;
import javax.xml.parsers.ParserConfigurationException;
import com.grupo2.constants.Constants;

/**
 *
 * @author fibrizo
 */
public class ThirdScenarioTest {
    
    private Pacman thePacman;
    private Ghost theGhost;
    private Maze maze;
    private Board map;
    
    public ThirdScenarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws ParserConfigurationException {
        Constants.VISION1 = 12;
        MazeXMLBuilder mazeBuilder = new MazeXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "LaberintoVacio.xml"));        
        CharacterBuilder charBuilder = new CharacterXMLBuilder(Paths.get("src", "main", "resources", "laberintosprueba", "PersonajesPacmanYHunter.xml"));
        map = Board.createBoard(mazeBuilder, charBuilder);
        theGhost = map.getGhosts().get(0);
        map.subscribeSubscribers();
        thePacman = map.getPacman();
        theGhost = map.getGhosts().get(0);
    }
    
    @After
    public void tearDown() {
    }

    @Test 
    public void PacmanMeetsHunterGhost() throws UnsupportedOperationException {

        Controller controller = new Controller(new MockReader());
        for (int i = 0; i < 8; i++) {
            map.updateModel(controller);
        }
        
        boolean OK = thePacman.getPosition().isEqualTo(new Coordinate(7,1)) && (thePacman.isDead());

        assertTrue(OK);
         
    }
}