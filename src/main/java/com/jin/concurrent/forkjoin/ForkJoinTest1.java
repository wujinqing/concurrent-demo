package com.jin.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author wu.jinqing
 * @date 2017年10月29日
 */
public class ForkJoinTest1 {
    private static int threshold = 3;
    public static class SumTask extends RecursiveTask<Integer>
    {
        private int[] src;
        private int start;
        private int len;

        public SumTask(int[] src, int start, int len) {
            this.src = src;
            this.start = start;
            this.len = len;
        }

        @Override
        protected Integer compute() {
            if(len < threshold)
            {
                int sum = 0;
                for(int i = start; i < start + len; i++)
                {

                    sum += src[i];
                }

                System.out.println(Thread.currentThread().getName());
                return sum;
            }else
            {
                int split = len / 2;

                SumTask t1 = new SumTask(src, start, split);
                SumTask t2 = new SumTask(src, (start + split), (len - split));

                t1.fork();
                t2.fork();
                // 这种方式将在线程池中执行
                return  t1.join() + t2.join();
                // 这种方式将在主线程中执行
//                return t1.invoke() + t2.invoke();

            }
        }
    }

    public static void main(String[] args) {
        int len = 10;
        int[] src = new int[len];

        for (int i = 0; i < len; i++)
        {
            src[i] = i;
        }

        // 初始化任务
        SumTask t1 = new SumTask(src, 0, src.length);
        // 创建线程池
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // 执行任务
        Integer sum = pool.invoke(t1);

        System.out.println(sum);
    }
}
