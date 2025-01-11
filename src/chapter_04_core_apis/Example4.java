package chapter_04_core_apis;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Working with Dates and Times
 */
public class Example4 {
    public static void main(String[] args) {
        title("Creating Dates and Times");
        print(LocalDate.now()); // Ex: 2024-09-11
        print(LocalTime.now()); // Ex: 20:19:07.986030400
        print(LocalDateTime.now()); // Ex: 2024-09-11T20:19:07.986030400
        print(ZonedDateTime.now()); // Ex: 2024-09-11T20:19:07.987030700-03:00[America/Sao_Paulo]
        print(LocalDate.of(2024, 9,6)); //  2024-09-06

        title("Manipulating Dates and Times");
        var date = LocalDate.of(2024, 9,6);
        print(date.plusDays(3)); // 2024-09-09
        print(date.plusWeeks(3)); // 2024-09-27
        print(date.plusMonths(3)); // 2024-12-06
        print(date.plusYears(3)); // 2027-09-06

        print(date.minusDays(3)); // 2024-09-03
        print(date.minusWeeks(3)); // 2024-08-16
        print(date.minusMonths(3)); // 2024-06-06
        print(date.minusYears(3)); // 2021-09-06

        print(date.getEra()); // CE (Common Era)
        print(date.getChronology()); // ISO
        print(date.getDayOfWeek()); // FRIDAY
        print(date.getLong(ChronoField.DAY_OF_YEAR)); // 250

        title("Working with Periods");
        print(Period.ofYears(3)); // P3Y
        print(Period.ofMonths(3)); // P3M
        print(Period.ofDays(3)); // P3D
        print(date.plus(Period.ofYears(1))); // 2025-09-06

        title("Working with Durations");
        print(Duration.ofDays(3)); // PT72H
        print(Duration.of(3, ChronoUnit.DAYS)); // PT72H
        print(Duration.ofHours(3)); // PT3H
        print(Duration.of(3, ChronoUnit.HOURS)); // PT3H
        print(Duration.ofMinutes(3)); // PT3M
        print(Duration.ofMillis(3)); // PT0.003S
        print(Duration.ofNanos(3)); // PT0.000000003S]

        title("ChronoUnit for Differences");
        print(ChronoUnit.DAYS.between(date, LocalDate.of(2024,1, 1))); // 249

        // Use Duration when you are working with LocalDateTime.
        // Use Period when you are working with LocalDate.

        title("Working with Instants");
        // The Instant class represents a specific moment in time in the GTM time zone.
        print(Instant.now()); // Ex: 2024-09-11T23:16:01.579796800Z

    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void title(String s) {
        System.out.println("\n" + '-' + s + '-');
    }
}
