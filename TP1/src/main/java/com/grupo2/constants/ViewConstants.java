/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.constants;

import java.nio.file.Paths;
import java.nio.file.Path;
import javax.swing.ImageIcon;

/**
 *
 * @author Familia
 */
public class ViewConstants {


    public final static int     DRAWABLE_HEIGHT = 48;
    public final static int     DRAWABLE_WIDTH = 48;
    public final static String  HUNTER_LEFT = Paths.get("src", "main", "graphicResources", "hunterLeft.png").toString();
    public final static String  HUNTER_RIGHT = Paths.get("src", "main", "graphicResources", "hunterRight.png").toString();
    public final static String  PREY_LEFT = Paths.get("src", "main", "graphicResources", "PreyLeft.png").toString();
    public final static String  PREY_RIGHT = Paths.get("src", "main", "graphicResources", "preyRight.png").toString();
    
    public final static String  PACMAN_LEFT = Paths.get("src", "main", "graphicResources", "PacmanLeft.png").toString();
    public final static String  PACMAN_RIGHT = Paths.get("src", "main", "graphicResources", "PacmanRight.png").toString();  
    
    private ViewConstants() {
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
          
}
