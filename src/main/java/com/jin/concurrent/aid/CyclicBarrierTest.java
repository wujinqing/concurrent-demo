package com.jin.concurrent.aid;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**将一个大任务分解成多个小任务，当所有任务执行完时将异步调用barrierAction实现后续任务
 *
 * CountDownLatch与CyclicBarrier的区别：参考
 * @see CountDownLatchTest
 *
 * @author wu.jinqing
 * @date 2017年06月19日
 */
public class CyclicBarrierTest {
    private static final int N = 3;
    private static final int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    private final static  int[] result = new int[3];

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(N, () -> {
            int sum = 0;
            for (int i : result) {
                sum += i;
            }

            System.out.println("sum: " + sum);
        });

        for (int i = 0; i < N; i++)
        {
            new Thread(new CyclicBarrierTest().new Compute(i, cyclicBarrier)).start();
        }

        System.out.println("other");
    }

    class Compute implements Runnable
    {
        private int row;
        private CyclicBarrier cyclicBarrier;

        public Compute(int row, CyclicBarrier cyclicBarrier) {
            this.row = row;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            int sum = 0;

            for (int i : data[row]) {
                sum +=i;
            }

            result[row] = sum;
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
