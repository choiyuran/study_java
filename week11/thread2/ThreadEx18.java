package javaStudy.week11.thread2;

public class ThreadEx18 {
    public static void main(String[] args) {
        YieldThread3 thread1 = new YieldThread3("Thread 1");
        YieldThread3 thread2 = new YieldThread3("Thread 2");
        YieldThread3 thread3 = new YieldThread3("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class YieldThread3 extends Thread {
    public YieldThread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": " + i);

            // 다른 스레드에게 실행 기회를 양보
            Thread.yield();
        }
    }
}
