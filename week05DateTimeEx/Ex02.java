package javaStudy.week05DateTimeEx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

// 화면으로 부터 날짜를 "2017/05/11"의 형태로 입력 받아서 무슨 요일인지 출력하는 프로그램 작성
// 단. 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력
public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        while (true) {
            System.out.println("날짜를 '2017/05/11' 형태로 입력해주세요: ");
            String input = sc.next().replace("/", "-");

            try {
                Date date = sdf.parse(input);
                cal.setTime(date);
                int day = cal.get(Calendar.DAY_OF_WEEK);
                String dayString = "";

                switch (day) {
                    case Calendar.SUNDAY:
                        dayString = "일요일";
                        break;
                    case Calendar.MONDAY:
                        dayString = "월요일";
                        break;
                    case Calendar.TUESDAY:
                        dayString = "화요일";
                        break;
                    case Calendar.WEDNESDAY:
                        dayString = "수요일";
                        break;
                    case Calendar.THURSDAY:
                        dayString = "목요일";
                        break;
                    case Calendar.FRIDAY:
                        dayString = "금요일";
                        break;
                    case Calendar.SATURDAY:
                        dayString = "토요일";
                        break;
                }
                System.out.println("입력하신 날짜는 " + dayString + "입니다.");
                break;      // while 반복 종료
            } catch (ParseException e) {
                System.out.println("잘못된 날짜 형식입니다. 다시 입력해주세요.");
            }
        }
        sc.close();
    }
}
