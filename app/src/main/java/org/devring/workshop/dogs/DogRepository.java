package org.devring.workshop.dogs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

public class DogRepository {

    private Map<String, Dog> dogsDatabase = new HashMap<>();

    public void connect(Map<String, Dog> dogsDatabase) {
        this.dogsDatabase = dogsDatabase;
    }

    public void add(Dog dog) {
        if (dogsDatabase.containsKey(dog.getName())) {
            throw new NonuniqueDogNameException(dog.getName());
        }

        dogsDatabase.put(dog.getName(), dog);
    }

    public boolean containsDogNamed(String name) {
        return dogsDatabase.containsKey(name);
    }

    public Set<Dog> getByBreed(String breed) {
        return dogsDatabase.values().stream()
        .filter(dog -> dog.getBreed().equals(breed) )
        .collect(Collectors.toSet());
    }

    public Dog findByName(String name) {
        return dogsDatabase.getOrDefault(name, null);
    }

    public Set<String> getAllBreeds() {
        return dogsDatabase.values().stream()
        .map(dog -> dog.getBreed() )
        .collect(Collectors.toSet());
    }

    public boolean isEmpty() {
        return dogsDatabase.isEmpty();
    }

    public void clear() {
        dogsDatabase.clear();
    }

    public void deleteByName(String dogName) {
        dogsDatabase.remove(dogName);
    }

}
