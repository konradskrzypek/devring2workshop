package org.devring.workshop.dogs;

import java.util.List;

public abstract class DogTestData {
    final static Dog SHARIK = Dog.of("Szarik", "german shepherd", false);
    final static Dog SNOOPY = Dog.of("Snoopy", "beagle", true);
    final static Dog SPOT = Dog.of("Spot", "beagle", false);
    final static Dog LAIKA = Dog.of("Laika", "siberian husky", false);

    final static List<Dog> ALL_DOGS = List.of(SHARIK, SNOOPY, SPOT, LAIKA);
}
