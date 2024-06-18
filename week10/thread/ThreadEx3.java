package javaStudy.week10.thread;

public class ThreadEx3 {
    public static void main(String[] args) {
        ThreadEx3_1 t1 = new ThreadEx3_1();
        // main쓰레드에 가져와서 run()메서드를 실행하기 때문에
        // main에서 실행하는 다른 코드에도 영향을 준다.
        // 즉, main에서도 에러가 발생
        t1.run();

        // 새로운 쓰레드를 생성하여 run()메서드를 실행하기 때문에
        // 에러가 발생해도 main에 영향을 미치지 않는다
        // 즉, main의 다른 코드는 실행 잘 됨.
        t1.start();
    }
}
class ThreadEx3_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

