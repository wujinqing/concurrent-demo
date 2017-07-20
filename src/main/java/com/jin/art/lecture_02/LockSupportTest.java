package com.jin.art.lecture_02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wu.jinqing
 * @date 2017年07月12日
 */
public class LockSupportTest {
    static Object obj = new Object();


    public static void main(String[] args) {
        Thread t3 = new Thread(() -> {
            LockSupport.park(obj);
            System.out.println("CCC");
        });

        Thread t1 = new Thread(() -> {
            LockSupport.park(obj);
            System.out.println("AAA");
//            LockSupport.unpark(t3);
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BBB");
            LockSupport.unpark(t1);
        });



        t1.start();
        t2.start();
        t3.start();


        try {
            Thread.sleep(10000);
            t3.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
