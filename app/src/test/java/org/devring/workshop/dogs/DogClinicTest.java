package org.devring.workshop.dogs;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DogClinicTest {

    @Mock
    Vet vet;

    @Mock
    Groomer groomer;

    @InjectMocks
    DogClinic dogClinic;

    @Test
    void shouldCallGroomerAndVetOnFull() {

        //given
        Dog dog = createDummyDog();
        //when
        dogClinic.checkupAndGroom(dog);

        BDDMockito.then(groomer).should().groom(dog);
        BDDMockito.then(vet).should().checkup(dog);
    }

    private Dog createDummyDog() {
        return Dog.of("foo", "bar");
    }
}
