package org.devring.workshop.dogs;

import static java.util.function.Function.identity;

import java.math.BigDecimal;
import java.text.CollationKey;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DogClinic {

    private final Vet vet;
    private final Groomer groomer;

    public HealthState checkupOnly(Dog dog) {
        return vet.checkup(dog);

    }

    public HealthState checkupAndGroom(Dog dog) {

        while (groomer.needsGrooming(dog)) {
            groomer.groom(dog);
        }
        return vet.checkup(dog);
    }

    public Map<Dog, HealthState> checkupAndGroom(Collection<Dog> dogs) {

        return dogs.stream()
        .collect(Collectors.toMap(identity(), dog -> checkupAndGroom(dog)));

    }

    public BigDecimal getCheckupPrice(Dog dog) {
        return vet.getPrice(dog);
    }

    public BigDecimal getCheckupAndGroomPrice(Dog dog) {
        if (groomer.needsGrooming(dog)) {
            return groomer.getPrice(dog).add(vet.getPrice(dog));
        }
        return vet.getPrice(dog);
    }

}
