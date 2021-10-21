package org.devring.workshop.dogs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.devring.workshop.dogs.DogRepositoryAssert.assertThat;
import static org.devring.workshop.dogs.DogTestData.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assert;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DogRepositoryTest {

    static DogRepository repository;
    static Map<String, Dog> mockDogsDatabase;

    @BeforeAll
    static void init() {
        repository = new DogRepository();
        // initialise the mock in-memory db
        mockDogsDatabase = new HashMap<>();
        repository.connect(mockDogsDatabase);
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void reset() {
        mockDogsDatabase.clear();
        ALL_DOGS.forEach(dog -> mockDogsDatabase.put(dog.getName(), dog));
        System.out.println("BeforeEach");
    }

    @AfterAll
    static void cleanup() {
        // destroy the in-memory database
        mockDogsDatabase.clear();
        System.out.println("AfterAll");
    }

    @Test
    void shouldGetByBreed() {
        // when
        var expectedBreed = "beagle";
        var actual = repository.getByBreed(expectedBreed);
        // then
        assertThat(actual).extracting("breed").containsOnly(expectedBreed);
        // TODO: assert names and fictionality
    }

    @Test
    void shouldRemoveADogAfterDelete() {
        // when
        repository.deleteByName(SNOOPY.getName());
        // then
        // assertThat(repository.containsDogNamed(SNOOPY.getName())).isFalse();
        assertThat(repository).doesntContainDog(SNOOPY);
    }

    @Test
    void shouldContainADogAfterAdd() {
        // TODO: implement
    }

}
