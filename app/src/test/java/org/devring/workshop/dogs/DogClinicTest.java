package org.devring.workshop.dogs;

import static org.devring.workshop.dogs.DogTestData.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.never;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void shouldCallGroomerAndVetOnFullCheckup() {

        //given
        BDDMockito.given(groomer.needsGrooming(LAIKA)).willReturn(true, false);
        //when
        dogClinic.checkupAndGroom(LAIKA);

        BDDMockito.then(groomer).should().groom(LAIKA);
        BDDMockito.then(vet).should().checkup(LAIKA);
    }

    @Test
    void shouldNotCallGroomerIfDogDoesntNeedGrooming() {

        //given
        // BDDMockito.given(groomer.needsGrooming(LAIKA)).willReturn(false);

        //when
        dogClinic.checkupAndGroom(LAIKA);

        //then
        BDDMockito.then(vet).should().checkup(LAIKA);
        BDDMockito.then(groomer).should(never()).groom(LAIKA);
    }

    @Test
    void shouldNotCallGroomerIfDogDoesntNeedGroomingForGroup() {

        //given
        ArgumentCaptor<Dog> argument = ArgumentCaptor.forClass(Dog.class);
        
        ALL_DOGS.forEach(dog -> {
            if (dog.isFictional()) {
                BDDMockito.given(groomer.needsGrooming(dog)).willReturn(false);
            } else {
                // BDDMockito.given(groomer.needsGrooming(dog)).willReturn(true, false);
                Mockito.when(groomer.needsGrooming(dog)).thenReturn(true, false);
            }
        });

        // gotcha!
        // BDDMockito.given(groomer.needsGrooming(argThat(dog -> dog!= null && dog.isFictional()))).willReturn(false);
        // BDDMockito.given(groomer.needsGrooming(argThat(dog -> dog!= null && !dog.isFictional()))).willReturn(true, false);

        BDDMockito.given(vet.checkup(any())).willReturn(HealthState.Healthy);
        //TODO: mock ill state on one of the dogs

        //when
        Map<Dog, HealthState> dogHealth = dogClinic.checkupAndGroom(ALL_DOGS);

        //then
        //TODO: verify fictional dogs are not groomed
        // either by adding explicit verification
        // BDDMockito.then(vet).should().checkup(....);
        
        // or by argument captor
        // Mockito.verify(groomer).groom(argument.capture());
        // using argument.getAllValues()
        Assertions.assertThat(dogHealth).containsOnlyKeys(ALL_DOGS);

    }

    //TODO add tests for get*Price methods

}
