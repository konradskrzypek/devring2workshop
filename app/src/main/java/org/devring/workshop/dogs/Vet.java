package org.devring.workshop.dogs;

import java.math.BigDecimal;

public interface Vet {
    HealthState checkup(Dog dog);
    BigDecimal getPrice(Dog dog);
}
