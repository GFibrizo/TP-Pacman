/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.ghostFactory;
import com.grupo2.interfaces.IGhost;

/**
 *
 * @author fibrizo
 */
public class GhostFactory {
    
    public static IGhost createGhost() {
        IGhost newGhost = new Ghost();
    }
    
}
