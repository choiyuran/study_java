package javaStudy.week12.thread3;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinEx2 extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int[] array;
    private int start, end;

    public ForkJoinEx2(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            ForkJoinEx2 leftTask = new ForkJoinEx2(array, start, middle);
            ForkJoinEx2 rightTask = new ForkJoinEx2(array, middle, end);
            // 쓰레드가 두개일 경우 하나의 쓰레드는 fork()로 비동기 실행
            // 나머지 하나는 compute()로 동기적으로 실행
            // 후에 fork()를 사용한 쓰레드에만 join()을 사용하여 가져오면 됨
            // 예를 들어, 세개의 쓰레드를 사용한다면 두 개의 쓰레드는 fork()
            // 나머지 하나의 쓰레드는 compute()로 실행
            leftTask.fork();            // 비동기 실행
            int rightResult = rightTask.compute();      // 동기적 실행
            int leftResult = leftTask.join();
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinEx2 task = new ForkJoinEx2(array, 0, array.length);
        int result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}
