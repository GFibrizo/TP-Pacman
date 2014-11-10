package com.grupo2.cell;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class TransitableCellTest {

    private Cell transCell;

    public TransitableCellTest() {
    }

    @Before
    public void setUp() {
        transCell = new Cell(2, 2, true);
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
