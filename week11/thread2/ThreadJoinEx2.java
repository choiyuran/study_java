package javaStudy.week11.thread2;

class SimpleThread extends Thread {
    private String name;

    public SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " 시작");
        try {
            // 스레드가 2초 동안 일하는 시뮬레이션
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 완료");
    }
}

public class ThreadJoinEx2 {
    public static void main(String[] args) {
        // 세 개의 스레드 생성
        SimpleThread thread1 = new SimpleThread("스레드 1");
        SimpleThread thread2 = new SimpleThread("스레드 2");
        SimpleThread thread3 = new SimpleThread("스레드 3");

        // 스레드 시작
        thread1.start();
        try {
            // thread1이 1초 동안만 기다림
            thread1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            // thread2가 1초 동안만 기다림
            thread2.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();
        try {
            // thread3이 1초 동안만 기다림
            thread3.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 스레드 상태 출력
        System.out.println("스레드 1 상태: " + thread1.getState());
        System.out.println("스레드 2 상태: " + thread2.getState());
        System.out.println("스레드 3 상태: " + thread3.getState());

        // 모든 스레드가 완료된 후 메시지 출력
        System.out.println("모든 스레드 완료");
    }
}
