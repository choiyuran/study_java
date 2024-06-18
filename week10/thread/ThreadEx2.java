package javaStudy.week10.thread;
class ThreadEx2_1 extends Thread {
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(getName());      // 조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx2_2 implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}

class ThreadEx2_3 implements Runnable {
    public void run() {
        for(int i = 0; i < 5; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            // getName()은 Thread에 있기 때문에 Runnable로 구현했을 경우
            // Thread.currentThread().getName()으로 호출해야 함.
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class ThreadEx2 {
    public static void main(String[] args) {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);          // 생성자 Thread(Runnable target)
        Runnable r2 = new ThreadEx1_3();
        Thread t3 = new Thread(r2);

        t1.start();
        t2.start();
        t3.start();

        new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }.run();            // 새로운 쓰레드를 생성하지 않기 때문에 main쓰레드가 출력됨.
    }
}
