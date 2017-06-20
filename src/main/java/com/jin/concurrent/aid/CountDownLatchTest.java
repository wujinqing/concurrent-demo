package com.jin.concurrent.aid;

import java.util.concurrent.CountDownLatch;

/**
 * 采用AQS实现，初始化时指定一个整数值count，countDown方法会将count值减1，await会一直阻塞直到count值为0则立刻返回。
 * CountDownLatch是一次性的，用过之后不能再重用，如果要重用请考虑使用CyclicBarrier。
 *
 * 适用场景：一个大任务切分成N个部分，只有当各个子部分都完成，大任务才算完成，才能继续做其他的事情。
 *
 * 两种情况：
 * 情况一：先调用await再调用countDown，await方法会一直阻塞直到count=0，适用于几个任务同时开始干的场景
 * 情况二：先调用countDown再调用await，适用于先完成的任务等待其他任务完成再进行其他任务。
 *
 * CountDownLatch与CyclicBarrier的区别：
 * CountDownLatch：
 *      1.主线程可以调用await方法等待使用的子线程执行完，再继续执行后续流程。
 *      2.不能重用。
 * CyclicBarrier：
 *      1.通过提供一个barrierAction，当所有子线程都执行完，会调用这个Action，无法阻止主流程继续执行。
 *      2.调用reset可以重用。
 *
 * @author wu.jinqing
 * @date 2017年06月19日
 */
public class CountDownLatchTest {
    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startSignal = new CountDownLatch(1);
        final CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; i++)
        {
            new Thread(() -> {
                try {
                    startSignal.await();
                    System.out.println(Thread.currentThread().getName() + ": doSomething");
                    doneSignal.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(3000);
        startSignal.countDown();

        doneSignal.await();
        System.out.println("end");
    }
}
