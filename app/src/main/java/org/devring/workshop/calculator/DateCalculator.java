package org.devring.workshop.calculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Collectors;


public class DateCalculator {

    public boolean isItFriday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }
 
    public LocalDateTime addHours(LocalDateTime date, int hours) {
        return date.plus(hours, ChronoUnit.HOURS);
    }

    public Set<Integer> getLeapYears(Set<LocalDate> dates) {
        return dates.stream()
            .filter(LocalDate::isLeapYear)
            .map(LocalDate::getYear)
            .collect(Collectors.toSet());
    }
    
}
