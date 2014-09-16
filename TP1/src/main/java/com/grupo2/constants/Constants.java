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

    public static float PREY_LIMIT_TIME = 30;
    public static float DEAD_LIMIT_TIME = 20;

    public static float FIRST_RAGE_LIMIT_TIME = 5;
    public static float SECOND_RAGE_LIMIT_TIME = 10;
    public static float THIRD_RAGE_LIMIT_TIME = 15;

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
}
