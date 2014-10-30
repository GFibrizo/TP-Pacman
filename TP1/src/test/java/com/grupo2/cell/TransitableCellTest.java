package com.grupo2.cell;

import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class TransitableCellTest {

    TransitableCell transCell;

    public TransitableCellTest() {
    }

    @BeforeClass
    public static void setUp() {

        TransitableCell transCell = new TransitableCell(2, 2);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isTransitable method, of class TransitableCell.
     */
    @Test
    public void isTransitable() {

        boolean result = transCell.isTransitable();
        assertTrue(result);
    }

    /**
     * Test of isTheSame method, of class TransitableCell.
     */
    @Test
    public void isTheSame() {

        boolean result = transCell.isTheSame(transCell);
        assertTrue(result);
    }

}
