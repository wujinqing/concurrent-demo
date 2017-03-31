package com.jin.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class AtomicIntegerTest {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> {
//
//        });
//
//        Thread thread2 = new Thread(() -> {
//
//        });
//
//        Thread thread3 = new Thread(() -> {
//
//        });

//        AtomicInteger atomicInteger1 = new AtomicInteger();
//        AtomicInteger atomicInteger2 = new AtomicInteger();
//
//        System.out.println(atomicInteger1.get());
//        System.out.println(atomicInteger2.get());
//        System.out.println(atomicInteger.get());

//        AtomicInteger atomicInteger = new AtomicInteger(100);
//
//        int i = atomicInteger.getAndSet(200);
//        int j = atomicInteger.get();
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(atomicInteger.get());

//        AtomicInteger atomicInteger = new AtomicInteger(100);
//
//        atomicInteger.compareAndSet(100, 300);
//
//        System.out.println(atomicInteger.get());

        AtomicInteger atomicInteger = new AtomicInteger(100);

//        System.out.println(atomicInteger.getAndIncrement());
//        System.out.println(atomicInteger.get());
//        System.out.println(atomicInteger.getAndDecrement());
//        System.out.println(atomicInteger.get());
//        System.out.println(atomicInteger.getAndAdd(20));
//        System.out.println(atomicInteger.get());

//        System.out.println(atomicInteger.incrementAndGet());

//        System.out.println(atomicInteger.addAndGet(10));

//        System.out.println(atomicInteger.getAndUpdate(i -> i + 10));
//        System.out.println(atomicInteger.get());

//        System.out.println(atomicInteger.updateAndGet(i -> i + 20));
        System.out.println(atomicInteger.accumulateAndGet(30, (i, j) -> i + j));


































    }
}
