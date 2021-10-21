package org.devring.workshop.dogs;

import lombok.Value;

@Value(staticConstructor = "of")
class Dog {
    private final String name;
    private final String breed;
    private final boolean fictional;
}