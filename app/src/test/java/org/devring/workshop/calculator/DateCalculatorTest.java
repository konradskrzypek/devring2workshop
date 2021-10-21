package org.devring.workshop.calculator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateCalculatorTest {


    @Test
    void isItFridayShouldReturnTrueOnFriday() {
        //given
        //when
        LocalDate testDate = LocalDate.parse("2021-10-22");
        var actual = new DateCalculator().isItFriday(testDate);
        //then
        assertTrue(actual, () -> String.format("%s is not friday (sadly)", testDate));
    }

    // TODO: add test for days other than friday 
    @Test 
    void isItFridayShouldReturnFalseOnDayOtherThanFriday() {
    }

    @Test
    void isItFridayShouldThrowOnNull() {
        //TODO: add message checking, verify if test fails on wrong expected message
        // hint: actualException.getMesssage
        var actualException = assertThrows(IllegalArgumentException.class, () -> new DateCalculator().isItFriday(null));
    }

    @Test
    //TODO: convert to parameterized
    void getDaysOfWeekFromDateShouldReturnCorrectArray() {
        //given
        var expected = new String[] {"FRIDAY", "SATURDAY", "SUNDAY"};
        //when
        var actual = new DateCalculator().getDaysOfWeekFromDate(LocalDate.parse("2021-10-22"), 3);
        //then
        assertArrayEquals(expected, actual);
    }


    // @ParameterizedTest(name = "#{index} - add date {0} + {1}")
    // @CsvSource(
    //     delimiterString = ";",
    //     value = {"2020-01-01T00:00:00;12;2020-01-01T12:00:00"
    //     ,"2020-01-01T01:00:00;12;2020-01-01T13:00:00"})
    void shouldAddHoursToDate() {
        //given
        var expected = LocalDateTime.parse("2020-01-01T12:00:00");
    
        //when
        var actual = new DateCalculator().addHours(LocalDateTime.parse("2020-01-01T00:00:00"), 12);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
