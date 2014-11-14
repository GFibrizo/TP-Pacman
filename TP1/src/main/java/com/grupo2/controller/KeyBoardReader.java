/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.controller;

import com.grupo2.character.Direction;
import com.grupo2.directions.DownDirection;
import com.grupo2.directions.LeftDirection;
import com.grupo2.directions.RightDirection;
import com.grupo2.directions.UpDirection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Familia
 */
public class KeyBoardReader implements InputReader, KeyListener {

	private Direction readedDirection;

	@Override
	public Direction getNextDirection() {
		return readedDirection;
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
////            readedDirection = new RightDirection();
//			System.out.println("Key typed: " + e.getKeyCode());
//		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			readedDirection = new LeftDirection();
//		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			readedDirection = new UpDirection();
//		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			readedDirection = new DownDirection();
//		} else {
//			System.out.println("Key typed: " + e.getKeyChar());
//		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			readedDirection = new RightDirection();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			readedDirection = new LeftDirection();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			readedDirection = new UpDirection();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			readedDirection = new DownDirection();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
////            readedDirection = new RightDirection();
//			System.out.println("Key typed: " + e.getKeyCode());
//		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			readedDirection = new LeftDirection();
//		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			readedDirection = new UpDirection();
//		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//			readedDirection = new DownDirection();
//		}
	}

}
