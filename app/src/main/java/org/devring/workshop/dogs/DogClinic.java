package org.devring.workshop.dogs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DogClinic {

    private final Vet vetService;
    private final Groomer groomerService;


    public HealthState checkupOnly(Dog dog) {
        return vetService.checkup(dog);

    }
    
    public HealthState checkupAndGroom(Dog dog) {
        groomerService.groom(dog);
        return vetService.checkup(dog);
    }
    
}
