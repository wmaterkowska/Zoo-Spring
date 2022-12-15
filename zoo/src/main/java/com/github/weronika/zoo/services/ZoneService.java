package com.github.weronika.zoo.services;

import com.github.weronika.exceptions.ExceededLimitOfFoodException;
import com.github.weronika.exceptions.UnknownSpeciesException;
import com.github.weronika.zoo.db.model.*;
import com.github.weronika.zoo.db.repo.AnimalRepository;
import com.github.weronika.zoo.db.repo.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZoneService {

    private ZoneRepository zoneRepository;
    private AnimalRepository animalRepository;



    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    public void addZone(String nameOfZone) {
        Zone newZone = new Zone(nameOfZone);
        zoneRepository.save(newZone);
    }

    public List<Animal> getAnimalsForZone(Zone zone) {
        List<Animal> animalsOfTheZone = new ArrayList<>();
        animalsOfTheZone = zone.getListOfAnimals();
        return animalsOfTheZone;
    }

    public void addAnimalToZone(Animal animalToAssign, Zone zone) throws ExceededLimitOfFoodException {
        Animal foundAnimal = animalRepository.findAll().stream()
                .filter(a -> a.getSpecies().equals(animalToAssign.getSpecies()) && a.getName().equals(animalToAssign.getName()))
                .findFirst().get();
        Zone foundZone = zoneRepository.findAll().stream()
                .filter(z -> z.getName().equals(zone.getName()))
                .findFirst().get();

        foundZone.addAnimal(foundAnimal);
    }

    public Zone getZoneWithMaxAmountOfFeedNeeded() {
        Map<Zone, Integer> mapZoneAmountOfFood = new HashMap<>();
        if (zoneRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("There are no zones in your zoo.");
        } else {
            for (Zone zone : zoneRepository.findAll()) {
                mapZoneAmountOfFood.put(zone, zone.getAmountOfFood());
            }
            Integer maxAmount = mapZoneAmountOfFood.values().stream().max(Integer::compare).get();

            return mapZoneAmountOfFood.entrySet().stream().filter(entry -> maxAmount.equals(entry.getValue()))
                    .map(Map.Entry::getKey).findFirst().get();
        }
    }

    public Zone getZoneWIthMinNumberOfAnimals() {
        Map<Zone, Integer> mapZoneNumberOfAnimals = new HashMap<>();
        if (zoneRepository.findAll().isEmpty()) {
            throw new NoSuchElementException("There are no zones in your zoo.");
        } else {
            for (Zone zone : zoneRepository.findAll()) {
                mapZoneNumberOfAnimals.put(zone, zone.getListOfAnimals().size());
            }
            Integer minNUmber = mapZoneNumberOfAnimals.values().stream().min(Integer::compare).get();

            return mapZoneNumberOfAnimals.entrySet().stream().filter(entry -> minNUmber.equals(entry.getValue()))
                    .map(Map.Entry::getKey).findFirst().get();
        }
    }

}

