package com.github.weronika.zoo.db.model;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Zone> listOfZones;
    private List<Animal> listOfAnimals;


    public Zoo() {
        this.listOfZones = new ArrayList<>();
        this.listOfAnimals = new ArrayList<>();
    }

    public List<Zone> getListOfZones() { return listOfZones; }

    public void setListOfZones(List<Zone> listOfZones) { this.listOfZones = listOfZones; }

    public List<Animal> getListOfAnimals() { return listOfAnimals; }

    public void setListOfAnimals(List<Animal> listOfAnimals) { this.listOfAnimals = listOfAnimals; }

    public void addZone(Zone zone) {
        this.listOfZones.add(zone);
    }

    public void addAnimal(Animal animal) {
        listOfAnimals.add(animal);
    }


}
