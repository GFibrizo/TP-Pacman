package com.grupo2.ghost;

import com.grupo2.character.Coordinate;
import com.grupo2.character.Position;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class GhostTest {

    public GhostTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void move() {
        Ghost ghost = new Ghost(0,0);
        ghost.move();
        assert(ghost.getPosition().isEqualTo(new Position(0,0,0)));
    }
    
    @Test
    public void GhostCollision(){
        Ghost ghost1 = new Ghost(0, 0);
        Ghost ghost2 = new Ghost(0, 1);
        assert(ghost1.getPosition().isCollindingWith(ghost2.getPosition()));
    }

}
