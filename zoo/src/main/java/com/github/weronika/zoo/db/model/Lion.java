package com.github.weronika.zoo.db.model;

import org.github.wmaterkowska.zoo.service.Feeding;

public class Lion extends Animal implements Feeding {


    public Lion(String species, String name) {
        super(species, name);
        setAmountOfFood(11);
    }

    @Override
    public void setAmountOfFood() {
        setAmountOfFood(11);
    }
}
