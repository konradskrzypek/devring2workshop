package org.devring.workshop.calculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class DateCalculatorFluentTest {


    @Test
    void shouldReturnLeapYears() {
        //given
        Set<LocalDate> dates = IntStream.rangeClosed(2000, 2020).mapToObj(year -> LocalDate.of(year, 1, 2)).collect(Collectors.toSet());
        Set<Integer> expected = Set.of(2000, 2004, 2008, 2012, 2016, 2020);
        //when
        Set<Integer> actual = new DateCalculator().getLeapYears(dates);
        //then
        //TODO: use AssertJ
        // Assertions.assertThat(actual)...
        // Assertions.assertThat(actual.size())...

    }


    @Test
    void isItFridayShouldReturnTrueOnFriday() {
        //given
        //when
        LocalDate testDate = LocalDate.parse("2021-10-22");
        var actual = new DateCalculator().isItFriday(testDate);
        //then
        //TODO: use AssertJ
        
        // assertTrue(actual, () -> String.format("%s is not friday (sadly)", testDate));
    }

    @Test
    void shouldAddHoursToDate() {
        //given
        var expected = LocalDateTime.parse("2020-01-01T12:00:00");
    
        //when
        var actual = new DateCalculator().addHours(LocalDateTime.parse("2020-01-01T00:00:00"), 12);

        //then
        //TODO: use AssertJ 
   }

   @Test
   void isItFridayShouldThrowOnNull() {
        //TODO: use AssertJ
        //  assertThrows(IllegalArgumentException.class, () -> new DateCalculator().isItFriday(null));

        //hint: Assertions.assertThatThrownBy 
   }
}
