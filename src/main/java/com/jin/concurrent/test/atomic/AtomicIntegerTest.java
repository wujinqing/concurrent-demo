package com.jin.concurrent.test.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wu.jinqing
 * @date 2017年06月19日
 */
public class AtomicIntegerTest {
    static int i = 0;
    static AtomicInteger k = new AtomicInteger(0);


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (i < 100)
                System.out.println("t1.i=" + i++);

        });

        Thread t2 = new Thread(() -> {
            while (i < 100)
                System.out.println("t2.i=" + i++);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);

        Thread t3 = new Thread(() -> {
            while (k.get() < 100)
                System.out.println("t3.k=" + k.getAndIncrement());

        });

        Thread t4 = new Thread(() -> {
            while (k.get() < 100)
                System.out.println("t4.k=" + k.getAndIncrement());
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println(k.get());
    }
}
