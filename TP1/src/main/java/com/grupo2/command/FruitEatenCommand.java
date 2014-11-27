package com.grupo2.command;

import com.grupo2.eventHandling.Subscriber;
import com.grupo2.fruit.Fruit;

/**
 *
 * @author fibrizo
 */
public class FruitEatenCommand implements Subscriber {

    Fruit fruit;

    public FruitEatenCommand(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void execute() {
        fruit.eat();
    }

}
