/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.fruit;

import com.grupo2.cell.Cell;
import com.grupo2.character.Character;
import com.grupo2.character.Coordinate;
import com.grupo2.constants.Constants;
import com.grupo2.directions.NullDirection;
import com.grupo2.maze.Maze;
import com.grupo2.movementStrategies.RandomStrategy;
import java.util.Random;

/**
 *
 * @author mauri
 */
public abstract class Fruit extends Character {

    private RandomStrategy randomStrategy = new RandomStrategy();

    public Fruit(Maze maze) {
        super();
        this.currentCell = initialCell(maze);
        this.direction = this.randomStrategy.getNewDirection(allowedDirections());
        velocity = Constants.getInitialVelocity();
    }

    public Fruit() {
    }

    private Cell initialCell(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();
        Random random = new Random();
        boolean isTransitable = false;
        Cell aCell = null;
        int x, y;

        while (!isTransitable) {
            x = random.nextInt(width - 1);
            y = random.nextInt(height - 1);
            Coordinate coordinate = new Coordinate(x, y);
            aCell = maze.getCellFromCoordinates(coordinate);
            isTransitable = aCell.isTransitable();
        }

        return aCell;
    }

    @Override
    public void move() {
        Random random = new Random();
        int randNumber = random.nextInt(10) + 1;

        if (randNumber == 1) {
            if (!direction.isEqualTo(new NullDirection())) {
                previousDirection = direction;
            }
            this.direction = this.randomStrategy.getNewDirection(allowedDirections());
            this.currentCell = this.direction.stepForward(this.currentCell);
        }

    }

    public abstract void eat();

    public void revive() {
        this.alive = true;
    }
}
