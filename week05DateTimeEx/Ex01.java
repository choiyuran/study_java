package javaStudy.week05DateTimeEx;


import java.text.SimpleDateFormat;
import java.util.Calendar;

// Calender 클래스와 SimpleDateFormat클래스를 이용해서 2024년의 매월 두 번째 일요일의 날짜를 출력하시오.
public class Ex01 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd은 2번째 일요일입니다.");
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < 12; i++) {
            cal.set(2024, i, 1);

            int firstDay = cal.get(Calendar.DAY_OF_WEEK); // 달의 첫째 날의 요일
            // 먼저, 첫째 날의 요일에서 첫번째 일요일까지의 날짜 차이를 계산하고
            // 첫째 날에서 두번째 일요일까지의 날짜 차이를 구하는 방식
            int secondSunday = (1 - firstDay + 7) % 7 + 7; // 두 번째 일요일까지의 날짜 차이를 계산
            cal.add(Calendar.DATE, secondSunday); // 첫째 날에서 계산된 차이만큼 날짜를 더함
            System.out.println(sdf.format(cal.getTime()));
        }
    }
}

