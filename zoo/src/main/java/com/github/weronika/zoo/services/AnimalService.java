package com.github.weronika.zoo.services;

import com.github.weronika.exceptions.UnknownSpeciesException;
import com.github.weronika.zoo.db.model.*;
import com.github.weronika.zoo.db.repo.AnimalRepository;
import com.github.weronika.zoo.db.repo.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private ZoneRepository zoneRepository;
    private AnimalRepository animalRepository;


    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public void addAnimal(String species, String name) throws UnknownSpeciesException {
        Animal newAnimal = null;

        if (species.equals("lion")) {
            newAnimal = new Lion(species, name);
        } else if (species.equals("elephant")) {
            newAnimal = new Elephant(species, name);
        } else if (species.equals("rabbit")) {
            newAnimal = new Rabbit(species, name);
        } else {
            throw new UnknownSpeciesException("Unknown species.");
        }
        animalRepository.save(newAnimal);
    }

    public List<Animal> getAnimalsWithName(String name) {
        List<Animal> listOfAnimalsWithName = new ArrayList<>();

        for (Animal a : animalRepository.findAll()) {
            if (a.getName().equals(name)) {
                listOfAnimalsWithName.add(a);
            }
        }
        return  listOfAnimalsWithName;
    }

    public List<Animal> getAnimalsWithoutZone() {
        List<Animal> animalsList = animalRepository.findAll();

        List<Animal> animalsWithZone = new ArrayList<>();
        List<Zone> zonesList = zoneRepository.findAll();
        for (Zone zone : zonesList) {
            animalsWithZone.addAll(zone.getListOfAnimals());
        }

        List<Animal> animalsWithoutZone = new ArrayList<>();
        for (Animal animal: animalsList) {
            if (! animalsWithZone.contains(animal)) {
                animalsWithoutZone.add(animal);
            }
        }
        return animalsWithoutZone;
    }

}
