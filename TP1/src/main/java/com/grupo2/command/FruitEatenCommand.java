package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.fruit.Fruit;

/**
 *
 * @author fibrizo
 */
public class FruitEatenCommand implements Subscriber {

    /**
     * Fruit on which this command has effect.
     */
    Fruit fruit;

    /**
     * Constructor.
     *
     * @param fruit
     */
    public FruitEatenCommand(Fruit fruit) {
	this.fruit = fruit;
    }

    /**
     * overriden execute.
     */
    @Override
    public void execute() {
	fruit.eat();
    }

}
