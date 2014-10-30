package com.grupo2.constants;

import java.nio.file.Paths;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauri
 */
public class ConstantsTest {

    public ConstantsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of initializeConstants method, of class Constants.
     */
    @Test
    public void testInitializeConstants() {
        Constants.initializeConstants(Paths.get("src", "main", "resources", "Constants.json"));

        // TODO: acá se deberían probar todos los datos, pero como todos hacen lo mismo, puse 2 random
        double deadTimeResult = Constants.getDeadLimitTime();
        double radiusResult = Constants.getGhostRadius();

        assertTrue((radiusResult == 2) && (deadTimeResult == 20));
    }

}
