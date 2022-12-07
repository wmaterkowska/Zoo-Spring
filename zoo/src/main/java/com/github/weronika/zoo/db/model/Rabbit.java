package com.github.weronika.zoo.db.model;

import org.github.wmaterkowska.zoo.service.Feeding;

public class Rabbit extends Animal implements Feeding {

    public Rabbit(String species, String name) {
        super(species, name);
        setAmountOfFood(4);
    }

    @Override
    public void setAmountOfFood() {

        setAmountOfFood(4);
    }
}
