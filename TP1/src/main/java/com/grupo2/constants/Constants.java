/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.constants;

/**
 *
 * @author fibrizo
 */
public final class Constants {
    
    private static float PREY_LIMIT_TIME = 30;
    private static float DEAD_LIMIT_TIME = 20;

    private static float FIRST_RAGE_LIMIT_TIME = 5;
    private static float SECOND_RAGE_LIMIT_TIME = 10;
    private static float THIRD_RAGE_LIMIT_TIME = 15;
    
    private static float GHOST_RADIUS = 2;

    public static float getPREY_LIMIT_TIME() {
        return PREY_LIMIT_TIME;
    }

    public static float getDEAD_LIMIT_TIME() {
        return DEAD_LIMIT_TIME;
    }

    public static float getFIRST_RAGE_LIMIT_TIME() {
        return FIRST_RAGE_LIMIT_TIME;
    }

    public static float getSECOND_RAGE_LIMIT_TIME() {
        return SECOND_RAGE_LIMIT_TIME;
    }

    public static float getTHIRD_RAGE_LIMIT_TIME() {
        return THIRD_RAGE_LIMIT_TIME;
    }

    public static float getGHOST_RADIUS() {
        return GHOST_RADIUS;
    }



    private Constants() {
        //this prevents even the native class from 
        //calling this ctor as well :
        throw new AssertionError();
    }

    public static void setPREY_LIMIT_TIME(float PREY_LIMIT_TIME) {
        Constants.PREY_LIMIT_TIME = PREY_LIMIT_TIME;
    }

    public static void setDEAD_LIMIT_TIME(float DEAD_LIMIT_TIME) {
        Constants.DEAD_LIMIT_TIME = DEAD_LIMIT_TIME;
    }

    public static void setFIRST_RAGE_LIMIT_TIME(float FIRST_RAGE_LIMIT_TIME) {
        Constants.FIRST_RAGE_LIMIT_TIME = FIRST_RAGE_LIMIT_TIME;
    }

    public static void setSECOND_RAGE_LIMIT_TIME(float SECOND_RAGE_LIMIT_TIME) {
        Constants.SECOND_RAGE_LIMIT_TIME = SECOND_RAGE_LIMIT_TIME;
    }

    public static void setTHIRD_RAGE_LIMIT_TIME(float THIRD_RAGE_LIMIT_TIME) {
        Constants.THIRD_RAGE_LIMIT_TIME = THIRD_RAGE_LIMIT_TIME;
    }
    
    public static void setGHOST_RADIUS(float RADIUS) {
        Constants.GHOST_RADIUS = RADIUS;
    }
}
