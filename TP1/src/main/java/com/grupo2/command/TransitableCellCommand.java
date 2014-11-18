/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.command;

import com.grupo2.cell.Cell;
import com.grupo2.eventHandling.Subscriber;

/**
 *
 * @author mauri
 */
public abstract class TransitableCellCommand implements Subscriber {

    Cell cell;
}
