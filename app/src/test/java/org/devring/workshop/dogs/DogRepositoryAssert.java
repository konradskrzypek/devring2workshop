package org.devring.workshop.dogs;

import org.assertj.core.api.AbstractAssert;

public class DogRepositoryAssert extends AbstractAssert<DogRepositoryAssert, DogRepository> {

    protected DogRepositoryAssert(DogRepository actual) {
        super(actual, DogRepositoryAssert.class);
    }

    public static DogRepositoryAssert assertThat(DogRepository actual) {
        return new DogRepositoryAssert(actual);
    }

    public DogRepositoryAssert containsDog(Dog dog) {
        isNotNull();
        if (!actual.containsDogNamed(dog.getName())) {
            failWithMessage("Expected DogRepository to contain dog named %s", dog.getName());
        }
        return this;
    }

    public DogRepositoryAssert doesntContainDog(Dog dog) {
        isNotNull();
        if (actual.containsDogNamed(dog.getName())) {
            failWithMessage("Expected DogRepository to not contain dog named %s", dog.getName());
        }
        return this;
    }
}
