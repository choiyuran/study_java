package javaStudy.week05DateTimeEx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.
public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while(true) {
            System.out.println("생년월일을 입력하세요 (yyyy-MM-dd): ");
            String birthDay = sc.next();

            try {
                Date birthDate = sdf.parse(birthDay);
                Date currentDate = new Date(); // 현재 날짜

                // 두 날짜 사이의 차이를 계산 (getTime()은 밀리초)
                long difference = currentDate.getTime() - birthDate.getTime();
                // 1초 = 1000밀리초
                // 1분 = 60초
                // 1시간 = 60분
                // 1일 = 24시간
                long days = difference / (24 * 60 * 60 * 1000);
                System.out.println("태어난지 " + days + "일 되었습니다.");
                break;
            } catch (ParseException e) {
                System.out.println("날짜 형식이 잘못되었습니다. yyyy-MM-dd 형식을 사용해 주세요.");
            }
        }
        sc.close();
    }
}
