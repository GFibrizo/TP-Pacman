/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.balls;

/**
 *
 * @author mauri
 */
public class LittleBall implements Ball {

    @Override
    public int isEaten() {
        //POR AHORA SETEARLE A LA CELDA EN LA QUE ESTÉ LA BOLITA, UNA NULL BALL. LUEGO TAMBIÉN SUMARÁ PUNTOS AL JUEGO.
        return 10;
    }

    @Override
    public boolean isEatable() {
        return true;
    }

    @Override
    public String toString() {
        return "bolita";
    }
}
