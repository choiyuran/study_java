package javaStudy.week05DateTimeEx2;

import java.util.Calendar;

// 어떤 회사의 월급날이 매월 21일이다.
// 두 날짜 사이에 월급 날이 몇번 있는지 계산하여 반환하는 메서드 작성
public class Ex04 {
    public static int countPaydays(Calendar start, Calendar end) {
        int paydaysCount = 0;

        // 시작일이 종료일보다 이후일 경우
        if (start.after(end)) {
            return 0;
        }

        // 시작일부터 종료일까지 매월 21일이 포함되는지 체크
        Calendar cal = (Calendar) start.clone();
        cal.set(Calendar.DAY_OF_MONTH, 21);             // 월급 날

        // 월급 날이 종료일보다 이후가 아닐 경우
        // 즉, 월급 날이 종료일 보다 작거나 같을때까지 반복
        while (!cal.after(end)) {
            // while반복에서 종료일과 월급 날의 관계를 설정했기 때문에 if에서는 시작일과 월급 날의 관계를 설정하면 됨.
            // 월급 날이 시작일보다 크거나 같을 때,
            // 시작일과 종료일 사이에 월급 날이 있다고 볼 수 있음
            if ((cal.after(start) || cal.equals(start))) {
                paydaysCount++;
            }
            // 다음 달로 이동
            cal.add(Calendar.MONTH, 1);
        }
        return paydaysCount;
    }

    public static void main(String[] args) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        // 2024년 5월 1일
        startDate.set(2024, Calendar.MAY, 1);
        // 2024년 10월 10일
        endDate.set(2024, Calendar.OCTOBER, 10);

        System.out.println("월급날의 수 : " + countPaydays(startDate, endDate));
    }

}
