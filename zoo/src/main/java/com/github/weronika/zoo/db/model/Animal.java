package com.github.weronika.zoo.db.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    @Column
    @NotNull
    private String species;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Integer amountOfFood;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        this.amountOfFood = 0;
    }


    public String getSpecies() { return species; }

    public void setSpecies(String species) { this.species = species; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getAmountOfFood() { return amountOfFood; }

    public void setAmountOfFood(Integer amountOfFood) { this.amountOfFood = amountOfFood; }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Animal animal = (Animal) obj;
        if (animal.getSpecies().equals(this.species) && animal.getName().equals(this.name)) {
            return true;
        }
        return false;
    }

}
