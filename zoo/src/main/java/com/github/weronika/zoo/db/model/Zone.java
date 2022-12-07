package com.github.weronika.zoo.db.model;

import com.github.weronika.exceptions.ExceededLimitOfFoodException;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long idZone;

    @Column
    @NotNull
    private String name;

    @Column
    private Integer amountOfFood;

    @Column
    @NotNull
    private final Integer maxAmountOfFood = 100;

    @Column
    @OneToMany(mappedBy = "animal", targetEntity = Animal.class)
    private List<Animal> listOfAnimals;



    public Zone(String name) {
        this.name = name;
        amountOfFood = 0;
        this.listOfAnimals = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAmountOfFood() { return amountOfFood; }

    public void setAmountOfFood(Integer amountOfFood) { this.amountOfFood = amountOfFood; }

    public Integer getMaxAmountOfFood() { return maxAmountOfFood; }

    public List<Animal> getListOfAnimals() { return listOfAnimals; }

    public void setListOfAnimals(List<Animal> listOfAnimals) { this.listOfAnimals = listOfAnimals; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Zone zone = (Zone) obj;
        return zone.getName().equals(this.name);
    }


    public void addAnimal(Animal animal) throws ExceededLimitOfFoodException {
        if (this.amountOfFood + animal.getAmountOfFood() <= maxAmountOfFood) {
            this.amountOfFood += animal.getAmountOfFood();
            this.listOfAnimals.add(animal);
        } else {
            throw new ExceededLimitOfFoodException("The maximum amount of food for this zone was exceeded.");
        }
    }
}
