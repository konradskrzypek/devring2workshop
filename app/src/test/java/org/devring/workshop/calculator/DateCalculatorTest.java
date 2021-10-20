package org.devring.workshop.calculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateCalculatorTest {


    @Test
    void shouldReturnLeapYears() {
        //given
        var dates = IntStream.rangeClosed(2000, 2020).mapToObj(year -> LocalDate.of(year, 1, 2)).collect(Collectors.toSet());
        var expected = Set.of(2000, 2004, 2008, 2012, 2016, 2020);
        //when
        var actual = new DateCalculator().getLeapYears(dates);
        //then
        //TODO: assert collections
        // org.assertj.core.api.Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }


    @Test
    void isItFridayShouldReturnTrueOnFriday() {
        //given
        //when
        LocalDate testDate = LocalDate.parse("2021-10-22");
        var actual = new DateCalculator().isItFriday(testDate);
        //then
        assertTrue(actual, () -> String.format("%s is not friday (sadly)", testDate));
    }

    @Test
    void isItFridayShouldReturnFalseOnDayOtherThanFriday() {
        //given
        //when
        var actual = new DateCalculator().isItFriday(LocalDate.parse("2021-10-21"));
        //then
        assertFalse(actual);
    }


    //TODO: convert to parameterized
    // @ParameterizedTest(name = "#{index} - add date {0} + {1}")
    // @CsvSource(
    //     delimiterString = ";",
    //     value = {"2020-01-01T00:00:00;12;2020-01-01T12:00:00"
    //     ,"2020-01-01T01:00:00;12;2020-01-01T13:00:00"})
    @Test
    void shouldAddHoursToDate() {
        //given
        var expected = LocalDateTime.parse("2020-01-01T12:00:00");
        //when
        
        var actual = new DateCalculator().addHours(LocalDateTime.parse("2020-01-01T00:00:00"), 12);
        //then

        Assertions.assertEquals(expected, actual);;
    }



}
