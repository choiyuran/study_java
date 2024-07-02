package javaStudy.week12.thread3;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinEx1 extends RecursiveAction {
    private static final int THRESHOLD = 2;
    private int[] array;
    private int start, end;

    public ForkJoinEx1(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                array[i] *= 2;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinEx1 leftTask = new ForkJoinEx1(array, start, middle);
            ForkJoinEx1 rightTask = new ForkJoinEx1(array, middle, end);
            leftTask.fork();
            rightTask.fork();
            leftTask.join();
            rightTask.join();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinEx1 action = new ForkJoinEx1(array, 0, array.length);
        pool.invoke(action);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
