package javaStudy.week10.thread;

import javax.swing.*;

class ThreadEx7_1 extends Thread {
    public void run() {
        for(int i = 10; i  > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);         // 1초간 시간을 지연한다.
            }catch (Exception e) {}
        }
        System.out.println("시간초과");
        System.exit(0);         // exit()는 현재 실행중인 모든 프로세스 종료.
    }       // run()
}

public class ThreadEx7 {
    public static void main(String[] args) {
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = JOptionPane.showInputDialog(("아무 값이나 입력하세요"));
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}
