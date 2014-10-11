package com.grupo2.ghost;

import com.grupo2.interfaces.IGhost;
import com.grupo2.character.Coordinate;
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
    
    IGhost ghost ;

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
        ghost = new Ghost(0,0);
    }

    @After
    public void tearDown() {
        ghost = null;
    }

    @Test
    public void move() {

        boolean notImplementedYet = false;
        try {
            ghost.move();
        } catch (UnsupportedOperationException e) {
            notImplementedYet = true;
        }
        assertTrue(notImplementedYet);
        assert(ghost.getPosition().isEqualTo(new Coordinate(0,0)));
    }
        
    @Test
    public void TryingToKillHunterGhost() {
        try {
            ghost.die();
        } catch (AssertionError e) {
            assert(true);
        }
    }
    
    @Test
    public void TryingToKillPreyGhost() {
        ghost.convertToPrey();
        ghost.die();
        assertTrue(ghost.isDead());
    }
    
    @Test
    public void TryingToConvertADeadToPrey() {
        ghost.convertToPrey();
        ghost.die();
        try {
            ghost.convertToPrey();
        } catch (AssertionError e) {
            assert(true);
        }
    }
}
