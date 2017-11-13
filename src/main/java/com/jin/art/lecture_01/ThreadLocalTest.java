package com.jin.art.lecture_01;

import java.util.concurrent.TimeUnit;

/**
 * @author wu.jinqing
 * @date 2017年06月28日
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> age = new ThreadLocal<>();
    private static ThreadLocal<String> name = new ThreadLocal<>();

    public static void main(String[] args) {
        age.set(1);
        name.set("main name");

        new Thread(() -> {
            age.set(2);
            name.set("thread 2");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A-" + age.get());
            System.out.println("A-" +name.get());
        }).start();

        new Thread(() -> {
            age.set(3);
            name.set("thread 3");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("B-" + age.get());
            System.out.println("B-" + name.get());
        }).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("M-" + age.get());
        System.out.println("M-" +name.get());
    }
}
