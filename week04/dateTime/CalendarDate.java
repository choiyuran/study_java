package javaStudy.week04.dateTime;

import java.util.Calendar;
import java.util.Date;

public class CalendarDate {
    public static void main(String[] args) {
        // Calendar를 Date로 변환
        Calendar cal = Calendar.getInstance();
        Date d = new Date(cal.getTimeInMillis());   // Date(long date)

        Date d2 = new Date();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);

        System.out.println(d);
        System.out.println(cal2.getTime());
    }
}
