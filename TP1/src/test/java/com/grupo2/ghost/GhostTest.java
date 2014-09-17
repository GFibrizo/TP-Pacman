package com.grupo2.ghost;

import com.grupo2.character.IGhost;
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
        assert(ghost.getPosition().isEqualTo(new Position(0,0,0)));
    }
    
    @Test
    public void GhostCollision(){
        IGhost ghost2 = new Ghost(0, 1);
        assert(ghost.isBeingEated(ghost2));
    }
    
    @Test
    public void GhostIsEatedByOtherGhost() {
        IGhost ghost2 = new Ghost(0, 1);
        ghost.beEated(ghost2);
        assertFalse(ghost.isDead());
    }

}
