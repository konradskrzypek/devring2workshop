package org.devring.workshop.dogs;

import lombok.Data;

@Data(staticConstructor = "of")
class Dog {
    private final String name;
    private final String breed;
}