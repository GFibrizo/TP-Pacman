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

  public static final float PREY_LIMIT_TIME = 30;
  public static final float DEAD_LIMIT_TIME = 20;
  
  public static final float FIRST_RAGE_LIMIT_TIME = 5;
  public static final float SECOND_RAGE_LIMIT_TIME = 10;
  public static final float THIRD_RAGE_LIMIT_TIME = 15;

  // PRIVATE //

  private Constants(){
    //this prevents even the native class from 
    //calling this ctor as well :
    throw new AssertionError();
  }
}