package javaStudy.week05.dateTime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BetweenEx {
    public static void main(String[] args) {
        // 날짜
        LocalDate date1 = LocalDate.of(2014, 1, 1);
        LocalDate date2 = LocalDate.of(2015, 12, 31);

        Period pe = Period.between(date1, date2);

        System.out.println("date1=" + date1);
        System.out.println("date2=" + date2);
        System.out.println("pe=" + pe);

        System.out.println("YEAR=" + pe.get(ChronoUnit.YEARS));
        System.out.println("MONTH=" + pe.get(ChronoUnit.MONTHS));
        System.out.println("DAY=" + pe.get(ChronoUnit.DAYS));

        // 시간
        LocalTime time1 = LocalTime.of(0, 0, 0);
        LocalTime time2 = LocalTime.of(12, 34, 56);

        Duration du = Duration.between(time1, time2);

        System.out.println("time1=" + time1);
        System.out.println("time2=" + time2);
        System.out.println("du=" + du);

        // Duration을 LocalTime으로 다시 바꿔서 시,분,초를 가져온다.
        LocalTime tmpTime = LocalTime.of(0,0).plusSeconds(du.getSeconds());

        System.out.println("HOUR=" + tmpTime.getHour());
        System.out.println("MINUTE=" + tmpTime.getMinute());
        System.out.println("SECOND=" + tmpTime.getSecond());
        System.out.println("NANO=" + tmpTime.getNano());
    }
}