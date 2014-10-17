package com.grupo2.pacman;

import com.grupo2.cell.Cell;
import com.grupo2.cell.RawCell;
import com.grupo2.character.Character;
import com.grupo2.character.Direction;
import com.grupo2.character.directions.NullDirection;
import com.grupo2.constants.Constants;

/**
 *
 * @author fibrizo
 */
public class Pacman extends Character {

    private Direction nextDirection;
    private boolean alive;
    private int score;

    public Pacman(final int x, final int y, final Direction dir) {
        super(x, y, dir);
        this.alive = true;
    }

<<<<<<< HEAD
	@Override
	public void move() {
	
        if ( this.nextDirection.canGoForward( (RawCell) currentCell) ) {
            this.direction = this.nextDirection;
            this.nextDirection = new NullDirection();
        }
            
        if ( this.direction.canGoForward( (RawCell)currentCell) ) {
            this.direction.stepForward(this); 
        }

        this.leaveTrace();
	}

        private int max(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
=======
    @Override
    public void move() {
        this.direction.stepForward(this);
        this.leaveTrace();
    }

    private int max(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }
>>>>>>> d43c4f4f93e49532e4796d0891e6fd1e9a5d629b

    private void leaveTrace() {
        int traceRadius = Constants.getTraceDuration();
        int initX = position.getX() - traceRadius;
        int initY = position.getY() - traceRadius;
        int endX = position.getX() + traceRadius + 1;
        int endY = position.getY() + traceRadius + 1;
        for (int i = initX; i < endX; i++) {
            for (int j = initY; j < endY; j++) {
                int traceLevelX = position.getX() - i;
                int traceLevelY = position.getY() - j;
                int traceLevel = max(traceLevelX, traceLevelY);
                // ACA ASIGNAR A LAS CELDAS EL RASTRO QUE CORRESPONDE
            }
        }
    }

    @Override
    public boolean isDead() {
        return !alive;
    }

    @Override
    public void changeDirection(final Direction theNewDirection) {
        this.direction = theNewDirection;
    }

    @Override
    public void die() {
        alive = false;
    }

}
