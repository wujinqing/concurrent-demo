package com.jin.art.lecture_01;

/**
 * Created by wujinqing on 17/6/21.
 */
public class ConcurrencyTest {
    public static final long count = 10000_0001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    public static void concurrency() throws InterruptedException
    {
        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {

            int a = 0;

            for (long i = 0; i < count; i++)
            {
                a += 5;
            }
        });

        t1.start();

        int b = 0;

        for (long i = 0; i < count; i++)
        {
            b--;
        }

        t1.join();
        long time = System.currentTimeMillis() - start;

        System.out.println("concurrency : " + time + "ms, b=" + b);

    }

    public static void serial()
    {
        long start = System.currentTimeMillis();


        int a = 0;

        for (long i = 0; i < count; i++)
        {
            a += 5;
        }


        int b = 0;

        for (long i = 0; i < count; i++)
        {
            b--;
        }

        long time = System.currentTimeMillis() - start;

        System.out.println("serial : " + time + "ms, b=" + b + ", a=" + a);
    }
}
