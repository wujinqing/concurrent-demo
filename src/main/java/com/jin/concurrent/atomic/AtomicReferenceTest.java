package com.jin.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wu.jinqing
 * @date 2017年03月30日
 */
public class AtomicReferenceTest {
    private static AtomicReference<Person> atomicReference = new AtomicReference<>(new Person("zhang san"));

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            Person p = atomicReference.get();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicReference.compareAndSet(p, new Person("li si"));

            System.out.println("thread1: " + b);
        });

        Thread thread2 = new Thread(() -> {
            Person p = atomicReference.get();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean b = atomicReference.compareAndSet(p, new Person("wang wu"));

            System.out.println("thread2: " + b);
        });

        thread1.start();
        thread2.start();
    }
}
