package org.devring.workshop.dogs;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("A dog repository")
public class DogRepositoryNestedTest {

    private final static Dog A_DOG = Dog.of("Dolly", "Yorkshire terrier", false);

    DogRepository repository;

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void create() {
            repository= new DogRepository();
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            Assertions.assertTrue(repository.isEmpty());
        }

        @Test
        @DisplayName("contains no breeds")
        void containsNoBreeds() {
            Assertions.assertTrue(repository.getAllBreeds().isEmpty());
        }

        @Nested
        @DisplayName("after adding a dog")
        class afterAdding {

            @BeforeEach
            void addADog() {
                repository.add(A_DOG);
            }

            @Test
            @DisplayName("is no longer emtpy")
            void isNoLongerEmpty() {
                assertFalse(repository.isEmpty());
            }

        }
    }
    
}
