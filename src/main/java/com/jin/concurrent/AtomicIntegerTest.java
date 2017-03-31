package com.jin.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wu.jinqing
 * @date 2017年03月21日
 */
public class AtomicIntegerTest {
    private static AtomicInteger count = new AtomicInteger(0);
    private static int fac = 0;
    private static final long AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    public static void increment()
    {
        synchronized (AtomicIntegerTest.class)
        {
            fac++;
        }
    }

    public static void increment2()
    {
        count.getAndIncrement();
    }

    public static void main(String[] args) {
//        long s = System.currentTimeMillis();
//
//        for (int i = 0; i <= 1000000; i++)
//        {
//            increment2();
//        }
//
//        long e = System.currentTimeMillis();
//        System.out.println(e - s);


        for (int i = 0; i <= 1000; i++)
        {
            System.out.println(Integer.numberOfLeadingZeros(i));
        }
    }
}
