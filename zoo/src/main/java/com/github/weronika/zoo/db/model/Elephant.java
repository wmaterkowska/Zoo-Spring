package com.github.weronika.zoo.db.model;

import org.github.wmaterkowska.zoo.service.Feeding;

public class Elephant extends Animal implements Feeding {

    public Elephant(String species, String name ) {
        super(species, name);
        setAmountOfFood(20);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(20);
    }
}
