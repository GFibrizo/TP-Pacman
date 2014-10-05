/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.constants;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("initializeConstants");
        String path = "../../../../../main/resources/Constants.json";
        Constants.initializeConstants(path);
        
        // TODO: acá se deberían probar todos los datos, pero como todos hacen lo mismo, puse 2 random
        double deadTimeResult = Constants.getDeadLimitTime();
        double radiusResult = Constants.getGhostRadius();
        
        assertTrue((radiusResult == 2) && (deadTimeResult == 20));
    }
    
}
