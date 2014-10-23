/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.grupo2.scenarios;

import com.grupo2.cell.TransitableCell;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.pacman.Pacman;
import org.junit.Before;

/**
 *
 * @author mauri
 */
public class ScenariosTest {
    private Pacman thePacman;    

    @Before
    public void setUp() {
        thePacman = Pacman.createPacman(0,0,new RightDirection());
        

    }
    
}
