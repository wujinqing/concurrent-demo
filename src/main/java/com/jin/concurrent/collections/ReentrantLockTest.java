package com.jin.concurrent.collections;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wu.jinqing
 * @date 2017年03月31日
 */
public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();

    public void doSomething() {
        lock.lock();  // block until condition holds
        try {
            for(int i = 0; i <= 100; i++)
            {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        } finally {
            lock.unlock();
        }
    }

    public void doAnotherthing() {
        for(int i = 0; i <= 100; i++)
        {
            System.out.println(Thread.currentThread().getName() + "=" + i);
        }
    }

    public static void main(String[] args) {
        final ReentrantLockTest lockTest = new ReentrantLockTest();

        Thread thread1 = new Thread(() -> {
            lockTest.doAnotherthing();
        });

        Thread thread2 = new Thread(() -> {
            lockTest.doAnotherthing();
        });

        Thread thread3 = new Thread(() -> {
            lockTest.doSomething();
        });

        Thread thread4 = new Thread(() -> {
            lockTest.doSomething();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
