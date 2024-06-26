package javaStudy.week05.dateTime;

import java.util.Calendar;

public class CalendarMain {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int date = today.get(Calendar.DATE);

        int woy = today.get(Calendar.WEEK_OF_YEAR);
        int wom = today.get(Calendar.WEEK_OF_MONTH);

        int doy = today.get(Calendar.DAY_OF_YEAR);
        int dom = today.get(Calendar.DAY_OF_MONTH);
        int dow = today.get(Calendar.DAY_OF_WEEK);

        int hour12 = today.get(Calendar.HOUR);
        int hour24 = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);

        int lastDate = today.getActualMaximum(Calendar.DATE);

        System.out.println("오늘은 " + year +"년 " + (month+1) + "월" + date +"일");
        System.out.println("오늘은 올해의 " + woy +"째주, 이번달의 " + wom + "째주. " + date +"일");
        System.out.println("오늘은 이번 해의 " + doy +"일이자, 이번 달의 " + dom + "일. 요일은 " + dow +"일 (1:일요일)");
        System.out.println("현재 시각은 " + hour12 +":"+ minute + ":"+ second +", 24시간으로 표현하면 " + hour24+":"+ minute + ":"+ second);
        System.out.println("오늘은 " + year +"년 " + (month+1) + "월" + date +"일");
        System.out.println("이 달의 마지막 날: " + lastDate);

    }
}
