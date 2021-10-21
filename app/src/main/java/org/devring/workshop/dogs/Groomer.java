package org.devring.workshop.dogs;

import java.math.BigDecimal;

public interface Groomer {
    void groom(Dog dog);
    boolean needsGrooming(Dog dog);
    BigDecimal getPrice(Dog dog);
}
