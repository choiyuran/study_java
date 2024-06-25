package javaStudy.week11.thread2;

public class ThreadJoinEx1 {
    public static void main(String[] args) {
        JoinThread thread1 = new JoinThread("Thread 1");
        JoinThread thread2 = new JoinThread("Thread 2");
        JoinThread thread3 = new JoinThread("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have completed their tasks.");
    }
}

class JoinThread extends Thread {
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(1000); // 1초 동안 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
