package javaStudy.week05.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();               // 오늘의 날짜
        LocalTime now = LocalTime.now();                // 현재 시간

        LocalDate birthDate = LocalDate.of(1999, 12, 31);        // 1999년 12월 31
        LocalTime birthTime = LocalTime.of(23, 59, 59);         // 23시 59분 59초

        System.out.println("today : " + today);
        System.out.println("now : " + now);
        System.out.println("birthDate : " + birthDate);             // 1999-12-31
        System.out.println("birthTime : " + birthTime);             // 23:59:59

        System.out.println(birthDate.withYear(2000));               // 2000-12-31
        System.out.println(birthDate.plusDays(1));       // 2000-01-01
        System.out.println(birthDate.plus(1, ChronoUnit.DAYS));     // 2000-01-01
        System.out.println(birthDate.minusYears(1));
        // 23:59:59 -> 23:00
        System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS));
    }
}
