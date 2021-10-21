package org.devring.workshop.calculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class DateCalculator {

    public boolean isItFriday(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date must not be null!");
        }
        return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
    }
 
    public LocalDateTime addHours(LocalDateTime date, int hours) {
        return date.plus(hours, ChronoUnit.HOURS);
    }

    public String[] getDaysOfWeekFromDate(LocalDate startDate, int numberOfDays) {
        return startDate.datesUntil(startDate.plusDays(numberOfDays))
        .map(date -> date.getDayOfWeek().toString())
        .collect(Collectors.toList())
        .toArray(new String[0]);
    }


    public Set<Integer> getLeapYears(Set<LocalDate> dates) {
        return dates.stream()
            .filter(LocalDate::isLeapYear)
            .map(LocalDate::getYear)
            .collect(Collectors.toSet());
    }

    public Set<LocalDate> filterNonLeapYears(Set<LocalDate> dates) {
        return dates.stream()
            .filter(LocalDate::isLeapYear)
            .collect(Collectors.toSet());
    }
    
}
