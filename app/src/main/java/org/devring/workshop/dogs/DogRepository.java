package org.devring.workshop.dogs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DogRepository {

    private Map<String, Dog> dogs = new HashMap<>();

    public void add(Dog dog) {
        if (dogs.containsKey(dog.getName())) {
            throw new NonuniqueDogNameException(dog.getName());
        }

        dogs.put(dog.getName(), dog);
    }

    public boolean containsDogNamed(String name) {
        return dogs.containsKey(name);
    }

    public Set<Dog> getByBreed(String breed) {
        return dogs.values().stream()
        .filter(dog -> dog.getBreed().equals(breed) )
        .collect(Collectors.toSet());
    }

    public void clear() {
        dogs.clear();
    }

}
