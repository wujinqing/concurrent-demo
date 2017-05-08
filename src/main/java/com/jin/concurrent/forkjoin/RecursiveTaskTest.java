package com.jin.concurrent.forkjoin;

import java.util.concurrent.*;

/**
 * @author wu.jinqing
 * @date 2017年05月03日
 */
public class RecursiveTaskTest extends RecursiveTask<Integer> {
    private int[] array;
    private int start, end;

    public RecursiveTaskTest(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public RecursiveTaskTest(int[] array) {
        this.array = array;
        this.start = 0;
        this.end = array.length;
    }

    @Override
    protected Integer compute() {
        System.out.println("start: " + start + ", end: " + end);
        int sum = 0;

        if(start == 6)
            throw new RuntimeException("test");

        if(end - start <= 2)
        {
            for (int i = start; i< end; i++) {
                sum += array[i];
            }
        }else
        {
            int mid = (start + end) / 2;

            RecursiveTaskTest left = new RecursiveTaskTest(array, start, mid);
            RecursiveTaskTest right = new RecursiveTaskTest(array, mid, end);

//            left.fork();
//            right.fork();
//
//            sum = left.join() + right.join();

            invokeAll(left, right);



            sum = left.getRawResult() + right.getRawResult();
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();

        RecursiveTaskTest task = new RecursiveTaskTest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        ForkJoinTask<Integer> result = pool.submit(task);

        if(result.isCompletedAbnormally())
        {
            System.out.println(result.getException());
        }
        System.out.println(result.get());
    }
}
