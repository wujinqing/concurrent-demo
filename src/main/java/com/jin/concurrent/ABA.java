package com.jin.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wu.jinqing
 * @date 2017年03月29日
 */
public class ABA {
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);

    public static void main(String[] args) throws InterruptedException {
        Thread intThread1 = new Thread(() -> {
            boolean b1 = atomicInteger.compareAndSet(100, 101);
            System.out.println("b1" + b1);
            boolean b2 = atomicInteger.compareAndSet(101, 100);
            System.out.println("b2" + b2);
        });

        Thread intThread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }

            boolean b3 = atomicInteger.compareAndSet(100, 101);

            System.out.println("b3" + b3);
        });

        intThread1.start();
        intThread2.start();
        intThread1.join();
        intThread2.join();

        Thread refThread1 = new Thread(() -> {
            try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }

            boolean b4 = atomicStampedRef.compareAndSet(100, 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("b4" + b4);
            boolean b5 = atomicStampedRef.compareAndSet(101, 100, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("b5" + b5);
        });

        Thread refThread2 = new Thread(() -> {
            int stamped = atomicStampedRef.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }

            boolean b6 = atomicStampedRef.compareAndSet(100, 101, stamped, stamped + 1);
            System.out.println("b6" + b6);
        });

        refThread1.start();
        refThread2.start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }

        System.out.println(atomicStampedRef.getStamp());

    }

//    private static AtomicInteger atomicInt = new AtomicInteger(100);
//    private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(100, 0);
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread intT1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                atomicInt.compareAndSet(100, 101);
//                atomicInt.compareAndSet(101, 100);
//            }
//        });
//
//        Thread intT2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                }
//                boolean c3 = atomicInt.compareAndSet(100, 101);
//                System.out.println(c3); // true
//            }
//        });
//
//        intT1.start();
//        intT2.start();
//        intT1.join();
//        intT2.join();
//
//        Thread refT1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                }
//                atomicStampedRef.compareAndSet(100, 101, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
//                atomicStampedRef.compareAndSet(101, 100, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
//            }
//        });
//
//        Thread refT2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int stamp = atomicStampedRef.getStamp();
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                }
//                boolean c3 = atomicStampedRef.compareAndSet(100, 101, stamp, stamp + 1);
//                System.out.println(c3); // false
//            }
//        });
//
//        refT1.start();
//        refT2.start();
//    }
}
