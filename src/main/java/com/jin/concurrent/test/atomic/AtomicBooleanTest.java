package com.jin.concurrent.test.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author wu.jinqing
 * @date 2017年06月19日
 */
public class AtomicBooleanTest {
    private static boolean flag2 = true;
    private static AtomicBoolean flag = new AtomicBoolean(true);
    private static boolean b = false;
    private static int k = 0;
    private static int h = 0;

    public static void main(String[] args) throws InterruptedException {
//        InterruptedExceptionThread t1 = new Thread(() -> {
//            while (k < 100f)
//            {
//                if(flag.get()) {
//                    System.out.println("t1.k=" + k++);
//
//                    flag.compareAndSet(true, false);
//                }
//            }
//
//        });
//
//        Thread t2 = new Thread(() -> {
//            while (k < 100)
//            {
//                if(!flag.get()) {
//                    System.out.println("t2.k=" + k++);
//
//                    flag.compareAndSet(false, true);
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println("结束");


        Thread t3 = new Thread(() -> {
            while (h < 100)
            {
                if(flag2) {
                    System.out.println("t3.h=" + h++);

                    flag2 = false;
                }
            }

        });

        Thread t4 = new Thread(() -> {
            while (h < 100)
            {
                if(!flag2) {
                    System.out.println("t4.h=" + h++);

                    flag2 = true;
                }
            }
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();



    }
}
